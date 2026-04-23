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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PlanDefinition
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object PlanDefinitionGoalSerializer : KSerializer<PlanDefinition.Goal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Goal") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", CodeableConcept.serializer().descriptor, isOptional = true)
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
      element("start", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "addresses",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "documentation",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "target",
        listSerialDescriptor(lazyDescriptor { PlanDefinition.Goal.Target.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Goal {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var description: CodeableConcept? = null
    var priority: CodeableConcept? = null
    var start: CodeableConcept? = null
    var addresses: List<CodeableConcept>? = null
    var documentation: List<RelatedArtifact>? = null
    var target: List<PlanDefinition.Goal.Target>? = null
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
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 ->
          description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 ->
          priority = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.categorySer, null)
        6 -> start = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.categorySer, null)
        7 ->
          addresses =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.addressesSer, null)
        8 ->
          documentation =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.documentationSer, null)
        9 -> target = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Goal: " + __i)
      }
    }
    return PlanDefinition.Goal(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      description = description!!,
      priority = priority,
      start = start,
      addresses = addresses ?: listOf(),
      documentation = documentation ?: listOf(),
      target = target ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PlanDefinition.Goal) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.description)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it)
    }
    (value.priority)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.categorySer, it) }
    (value.start)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.categorySer, it) }
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.addressesSer, value.addresses)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.documentationSer, value.documentation)
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.targetSer, value.target)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val addressesSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySer)

    public val documentationSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val documentationSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.documentationSerInner)

    public val targetSerInner: KSerializer<PlanDefinition.Goal.Target> =
      PlanDefinition.Goal.Target.serializer()

    public val targetSer: KSerializer<List<PlanDefinition.Goal.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

internal object PlanDefinitionGoalTargetSerializer : KSerializer<PlanDefinition.Goal.Target> {
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
      element("due", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Goal.Target {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var measure: CodeableConcept? = null
    var detailQuantity: Quantity? = null
    var detailRange: Range? = null
    var detailCodeableConcept: CodeableConcept? = null
    var due: Duration? = null
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
        7 -> due = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.dueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return PlanDefinition.Goal.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      measure = measure,
      detail =
        PlanDefinition.Goal.Target.Detail.from(detailQuantity, detailRange, detailCodeableConcept),
      due = due,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PlanDefinition.Goal.Target) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.measure)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.measureSer, it) }
    when (val __d = value.detail) {
      null -> {}
      is PlanDefinition.Goal.Target.Detail.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.detailQuantitySer, __d.value)
      }
      is PlanDefinition.Goal.Target.Detail.Range -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.detailRangeSer, __d.value)
      }
      is PlanDefinition.Goal.Target.Detail.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.measureSer, __d.value)
      }
    }
    (value.due)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.dueSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val measureSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val detailQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val detailRangeSer: KSerializer<Range> = Range.serializer()

    public val dueSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object PlanDefinitionActionSerializer : KSerializer<PlanDefinition.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
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
      element("prefix", KotlinString.serializer().descriptor, isOptional = true)
      element("_prefix", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("textEquivalent", KotlinString.serializer().descriptor, isOptional = true)
      element("_textEquivalent", Element.serializer().descriptor, isOptional = true)
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "documentation",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "goalId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_goalId", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "trigger",
        listSerialDescriptor(TriggerDefinition.serializer().descriptor),
        isOptional = true,
      )
      element(
        "condition",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.Condition.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "input",
        listSerialDescriptor(DataRequirement.serializer().descriptor),
        isOptional = true,
      )
      element(
        "output",
        listSerialDescriptor(DataRequirement.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedAction",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.RelatedAction.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("timingDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
      element("timingAge", Age.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingDuration", Duration.serializer().descriptor, isOptional = true)
      element("timingRange", Range.serializer().descriptor, isOptional = true)
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.Participant.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("groupingBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_groupingBehavior", Element.serializer().descriptor, isOptional = true)
      element("selectionBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_selectionBehavior", Element.serializer().descriptor, isOptional = true)
      element("requiredBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_requiredBehavior", Element.serializer().descriptor, isOptional = true)
      element("precheckBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_precheckBehavior", Element.serializer().descriptor, isOptional = true)
      element("cardinalityBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_cardinalityBehavior", Element.serializer().descriptor, isOptional = true)
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element("definitionUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionUri", Element.serializer().descriptor, isOptional = true)
      element("transform", KotlinString.serializer().descriptor, isOptional = true)
      element("_transform", Element.serializer().descriptor, isOptional = true)
      element(
        "dynamicValue",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.DynamicValue.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { PlanDefinition.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var prefix: KotlinString? = null
    var _prefix: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var textEquivalent: KotlinString? = null
    var _textEquivalent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var code: List<CodeableConcept>? = null
    var reason: List<CodeableConcept>? = null
    var documentation: List<RelatedArtifact>? = null
    var goalId: List<KotlinString?>? = null
    var _goalId: List<Element?>? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var trigger: List<TriggerDefinition>? = null
    var condition: List<PlanDefinition.Action.Condition>? = null
    var input: List<DataRequirement>? = null
    var output: List<DataRequirement>? = null
    var relatedAction: List<PlanDefinition.Action.RelatedAction>? = null
    var timingDateTime: KotlinString? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var participant: List<PlanDefinition.Action.Participant>? = null
    var type: CodeableConcept? = null
    var groupingBehavior: KotlinString? = null
    var _groupingBehavior: Element? = null
    var selectionBehavior: KotlinString? = null
    var _selectionBehavior: Element? = null
    var requiredBehavior: KotlinString? = null
    var _requiredBehavior: Element? = null
    var precheckBehavior: KotlinString? = null
    var _precheckBehavior: Element? = null
    var cardinalityBehavior: KotlinString? = null
    var _cardinalityBehavior: Element? = null
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionUri: KotlinString? = null
    var _definitionUri: Element? = null
    var transform: KotlinString? = null
    var _transform: Element? = null
    var dynamicValue: List<PlanDefinition.Action.DynamicValue>? = null
    var action: List<PlanDefinition.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> prefix = decoder.decodeStringElement(__desc, 3)
        4 -> _prefix = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.prefixSer, null)
        5 -> title = decoder.decodeStringElement(__desc, 5)
        6 -> _title = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.prefixSer, null)
        7 -> description = decoder.decodeStringElement(__desc, 7)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.prefixSer, null)
        9 -> textEquivalent = decoder.decodeStringElement(__desc, 9)
        10 ->
          _textEquivalent =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.prefixSer, null)
        11 -> priority = decoder.decodeStringElement(__desc, 11)
        12 ->
          _priority = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.prefixSer, null)
        13 -> code = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.codeSer, null)
        14 -> reason = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.codeSer, null)
        15 ->
          documentation =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.documentationSer, null)
        16 ->
          goalId = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.goalIdSer, null)
        17 ->
          _goalId = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.goalIdSer2, null)
        18 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.codeSerInner, null)
        19 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.subjectReferenceSer, null)
        20 ->
          trigger = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.triggerSer, null)
        21 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.conditionSer, null)
        22 -> input = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.inputSer, null)
        23 -> output = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.inputSer, null)
        24 ->
          relatedAction =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.relatedActionSer, null)
        25 -> timingDateTime = decoder.decodeStringElement(__desc, 25)
        26 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.prefixSer, null)
        27 ->
          timingAge =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.timingAgeSer, null)
        28 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.timingPeriodSer, null)
        29 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.timingDurationSer, null)
        30 ->
          timingRange =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.timingRangeSer, null)
        31 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.timingTimingSer, null)
        32 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.participantSer, null)
        33 ->
          type = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.codeSerInner, null)
        34 -> groupingBehavior = decoder.decodeStringElement(__desc, 34)
        35 ->
          _groupingBehavior =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.prefixSer, null)
        36 -> selectionBehavior = decoder.decodeStringElement(__desc, 36)
        37 ->
          _selectionBehavior =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.prefixSer, null)
        38 -> requiredBehavior = decoder.decodeStringElement(__desc, 38)
        39 ->
          _requiredBehavior =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.prefixSer, null)
        40 -> precheckBehavior = decoder.decodeStringElement(__desc, 40)
        41 ->
          _precheckBehavior =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.prefixSer, null)
        42 -> cardinalityBehavior = decoder.decodeStringElement(__desc, 42)
        43 ->
          _cardinalityBehavior =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.prefixSer, null)
        44 -> definitionCanonical = decoder.decodeStringElement(__desc, 44)
        45 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.prefixSer, null)
        46 -> definitionUri = decoder.decodeStringElement(__desc, 46)
        47 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.prefixSer, null)
        48 -> transform = decoder.decodeStringElement(__desc, 48)
        49 ->
          _transform =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.prefixSer, null)
        50 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.dynamicValueSer, null)
        51 ->
          action = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
      }
    }
    return PlanDefinition.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      prefix = R4String.of(prefix, _prefix),
      title = R4String.of(title, _title),
      description = R4String.of(description, _description),
      textEquivalent = R4String.of(textEquivalent, _textEquivalent),
      priority =
        priority?.let { Enumeration.of(PlanDefinition.RequestPriority.fromCode(it), _priority) },
      code = code ?: listOf(),
      reason = reason ?: listOf(),
      documentation = documentation ?: listOf(),
      goalId =
        (kotlin.collections.List(maxOf(goalId?.size ?: 0, _goalId?.size ?: 0)) { __i ->
          Id.of(goalId?.getOrNull(__i)?.let { it }, _goalId?.getOrNull(__i))!!
        }),
      subject = PlanDefinition.Action.Subject.from(subjectCodeableConcept, subjectReference),
      trigger = trigger ?: listOf(),
      condition = condition ?: listOf(),
      input = input ?: listOf(),
      output = output ?: listOf(),
      relatedAction = relatedAction ?: listOf(),
      timing =
        PlanDefinition.Action.Timing.from(
          DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
          timingAge,
          timingPeriod,
          timingDuration,
          timingRange,
          timingTiming,
        ),
      participant = participant ?: listOf(),
      type = type,
      groupingBehavior =
        groupingBehavior?.let {
          Enumeration.of(PlanDefinition.ActionGroupingBehavior.fromCode(it), _groupingBehavior)
        },
      selectionBehavior =
        selectionBehavior?.let {
          Enumeration.of(PlanDefinition.ActionSelectionBehavior.fromCode(it), _selectionBehavior)
        },
      requiredBehavior =
        requiredBehavior?.let {
          Enumeration.of(PlanDefinition.ActionRequiredBehavior.fromCode(it), _requiredBehavior)
        },
      precheckBehavior =
        precheckBehavior?.let {
          Enumeration.of(PlanDefinition.ActionPrecheckBehavior.fromCode(it), _precheckBehavior)
        },
      cardinalityBehavior =
        cardinalityBehavior?.let {
          Enumeration.of(
            PlanDefinition.ActionCardinalityBehavior.fromCode(it),
            _cardinalityBehavior,
          )
        },
      definition =
        PlanDefinition.Action.Definition.from(
          Canonical.of(definitionCanonical, _definitionCanonical),
          Uri.of(definitionUri, _definitionUri),
        ),
      transform = Canonical.of(transform, _transform),
      dynamicValue = dynamicValue ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PlanDefinition.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.prefix?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.prefix?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.prefixSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.prefixSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.prefixSer, it)
    }
    ((value.textEquivalent?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.textEquivalent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.prefixSer, it)
    }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.prefixSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.codeSer, value.code)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.codeSer, value.reason)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.documentationSer, value.documentation)
    (value.goalId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.goalIdSer, it)
    }
    (value.goalId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.goalIdSer2, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is PlanDefinition.Action.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.codeSerInner, __d.value)
      }
      is PlanDefinition.Action.Subject.Reference -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    if (value.trigger.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.triggerSer, value.trigger)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.conditionSer, value.condition)
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.inputSer, value.output)
    if (value.relatedAction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.relatedActionSer, value.relatedAction)
    when (val __d = value.timing) {
      null -> {}
      is PlanDefinition.Action.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26, Hoisted.prefixSer, it)
        }
      }
      is PlanDefinition.Action.Timing.Age -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.timingAgeSer, __d.value)
      }
      is PlanDefinition.Action.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.timingPeriodSer, __d.value)
      }
      is PlanDefinition.Action.Timing.Duration -> {
        encoder.encodeSerializableElement(__desc, 29, Hoisted.timingDurationSer, __d.value)
      }
      is PlanDefinition.Action.Timing.Range -> {
        encoder.encodeSerializableElement(__desc, 30, Hoisted.timingRangeSer, __d.value)
      }
      is PlanDefinition.Action.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 31, Hoisted.timingTimingSer, __d.value)
      }
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.participantSer, value.participant)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 33, Hoisted.codeSerInner, it) }
    ((value.groupingBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 34, it)
    }
    (value.groupingBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.prefixSer, it)
    }
    ((value.selectionBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 36, it)
    }
    (value.selectionBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.prefixSer, it)
    }
    ((value.requiredBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 38, it)
    }
    (value.requiredBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.prefixSer, it)
    }
    ((value.precheckBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 40, it)
    }
    (value.precheckBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.prefixSer, it)
    }
    ((value.cardinalityBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 42, it)
    }
    (value.cardinalityBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.prefixSer, it)
    }
    when (val __d = value.definition) {
      null -> {}
      is PlanDefinition.Action.Definition.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 44, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 45, Hoisted.prefixSer, it)
        }
      }
      is PlanDefinition.Action.Definition.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 46, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 47, Hoisted.prefixSer, it)
        }
      }
    }
    ((value.transform?.value))?.let { encoder.encodeStringElement(__desc, 48, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.prefixSer, it)
    }
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.dynamicValueSer, value.dynamicValue)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val prefixSer: KSerializer<Element> = Element.serializer()

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val documentationSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val documentationSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.documentationSerInner)

    public val goalIdSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val goalIdSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.goalIdSerInner).nullable)

    public val goalIdSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.prefixSer).nullable)

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val triggerSerInner: KSerializer<TriggerDefinition> = TriggerDefinition.serializer()

    public val triggerSer: KSerializer<List<TriggerDefinition>> =
      ListSerializer(Hoisted.triggerSerInner)

    public val conditionSerInner: KSerializer<PlanDefinition.Action.Condition> =
      PlanDefinition.Action.Condition.serializer()

    public val conditionSer: KSerializer<List<PlanDefinition.Action.Condition>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val inputSerInner: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val inputSer: KSerializer<List<DataRequirement>> = ListSerializer(Hoisted.inputSerInner)

    public val relatedActionSerInner: KSerializer<PlanDefinition.Action.RelatedAction> =
      PlanDefinition.Action.RelatedAction.serializer()

    public val relatedActionSer: KSerializer<List<PlanDefinition.Action.RelatedAction>> =
      ListSerializer(Hoisted.relatedActionSerInner)

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val participantSerInner: KSerializer<PlanDefinition.Action.Participant> =
      PlanDefinition.Action.Participant.serializer()

    public val participantSer: KSerializer<List<PlanDefinition.Action.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val dynamicValueSerInner: KSerializer<PlanDefinition.Action.DynamicValue> =
      PlanDefinition.Action.DynamicValue.serializer()

    public val dynamicValueSer: KSerializer<List<PlanDefinition.Action.DynamicValue>> =
      ListSerializer(Hoisted.dynamicValueSerInner)

    public val actionSerInner: KSerializer<PlanDefinition.Action> =
      PlanDefinition.Action.serializer()

    public val actionSer: KSerializer<List<PlanDefinition.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object PlanDefinitionActionConditionSerializer :
  KSerializer<PlanDefinition.Action.Condition> {
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
      element("kind", KotlinString.serializer().descriptor, isOptional = true)
      element("_kind", Element.serializer().descriptor, isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Condition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Condition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.Condition {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> kind = decoder.decodeStringElement(__desc, 3)
        4 -> _kind = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.kindSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Condition: " + __i)
      }
    }
    return PlanDefinition.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind = Enumeration.of(PlanDefinition.ActionConditionKind.fromCode(kind!!), _kind),
      expression = expression,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PlanDefinition.Action.Condition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.kindSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.expressionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val kindSer: KSerializer<Element> = Element.serializer()

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object PlanDefinitionActionRelatedActionSerializer :
  KSerializer<PlanDefinition.Action.RelatedAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedAction") {
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
      element("actionId", KotlinString.serializer().descriptor, isOptional = true)
      element("_actionId", Element.serializer().descriptor, isOptional = true)
      element("relationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_relationship", Element.serializer().descriptor, isOptional = true)
      element("offsetDuration", Duration.serializer().descriptor, isOptional = true)
      element("offsetRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.RelatedAction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actionId: KotlinString? = null
    var _actionId: Element? = null
    var relationship: KotlinString? = null
    var _relationship: Element? = null
    var offsetDuration: Duration? = null
    var offsetRange: Range? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> actionId = decoder.decodeStringElement(__desc, 3)
        4 ->
          _actionId =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actionIdSer, null)
        5 -> relationship = decoder.decodeStringElement(__desc, 5)
        6 ->
          _relationship =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.actionIdSer, null)
        7 ->
          offsetDuration =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.offsetDurationSer, null)
        8 ->
          offsetRange =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.offsetRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAction: " + __i)
      }
    }
    return PlanDefinition.Action.RelatedAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actionId = Id.of(actionId, _actionId)!!,
      relationship =
        Enumeration.of(
          PlanDefinition.ActionRelationshipType.fromCode(relationship!!),
          _relationship,
        ),
      offset = PlanDefinition.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.RelatedAction,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.actionId.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.actionId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.actionIdSer, it)
    }
    ((value.relationship.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.relationship.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.actionIdSer, it)
    }
    when (val __d = value.offset) {
      null -> {}
      is PlanDefinition.Action.RelatedAction.Offset.Duration -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.offsetDurationSer, __d.value)
      }
      is PlanDefinition.Action.RelatedAction.Offset.Range -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.offsetRangeSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionIdSer: KSerializer<Element> = Element.serializer()

    public val offsetDurationSer: KSerializer<Duration> = Duration.serializer()

    public val offsetRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object PlanDefinitionActionParticipantSerializer :
  KSerializer<PlanDefinition.Action.Participant> {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> role = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return PlanDefinition.Action.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(PlanDefinition.ActionParticipantType.fromCode(type!!), _type),
      role = role,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PlanDefinition.Action.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object PlanDefinitionActionDynamicValueSerializer :
  KSerializer<PlanDefinition.Action.DynamicValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DynamicValue") {
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
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.DynamicValue =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.DynamicValue) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.DynamicValue {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(__desc, 3)
        4 -> _path = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.pathSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + __i)
      }
    }
    return PlanDefinition.Action.DynamicValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R4String.of(path, _path),
      expression = expression,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.DynamicValue,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.path?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.pathSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.expressionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object PlanDefinitionSubjectSerializer : KSerializer<PlanDefinition.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition.Subject") {
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Subject) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PlanDefinition.Subject.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.subjectCodeableConceptSer, __d.value)
        }
        is PlanDefinition.Subject.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Subject =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Subject {
    val __desc = descriptor
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        1 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding PlanDefinition.Subject: " + __i)
      }
    }
    return PlanDefinition.Subject.from(subjectCodeableConcept, subjectReference)!!
  }

  private object Hoisted {
    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object PlanDefinitionGoalTargetDetailSerializer :
  KSerializer<PlanDefinition.Goal.Target.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition.Goal.Target.Detail") {
      element("detailQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("detailRange", Range.serializer().descriptor, isOptional = true)
      element("detailCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target.Detail) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PlanDefinition.Goal.Target.Detail.Quantity -> {
          encodeSerializableElement(__desc, 0, Hoisted.detailQuantitySer, __d.value)
        }
        is PlanDefinition.Goal.Target.Detail.Range -> {
          encodeSerializableElement(__desc, 1, Hoisted.detailRangeSer, __d.value)
        }
        is PlanDefinition.Goal.Target.Detail.CodeableConcept -> {
          encodeSerializableElement(__desc, 2, Hoisted.detailCodeableConceptSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target.Detail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Goal.Target.Detail {
    val __desc = descriptor
    var detailQuantity: Quantity? = null
    var detailRange: Range? = null
    var detailCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          detailQuantity =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.detailQuantitySer, null)
        1 ->
          detailRange =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.detailRangeSer, null)
        2 ->
          detailCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.detailCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding PlanDefinition.Goal.Target.Detail: " + __i
          )
      }
    }
    return PlanDefinition.Goal.Target.Detail.from(
      detailQuantity,
      detailRange,
      detailCodeableConcept,
    )!!
  }

  private object Hoisted {
    public val detailQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val detailRangeSer: KSerializer<Range> = Range.serializer()

    public val detailCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object PlanDefinitionActionSubjectSerializer : KSerializer<PlanDefinition.Action.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition.Action.Subject") {
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Subject) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PlanDefinition.Action.Subject.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.subjectCodeableConceptSer, __d.value)
        }
        is PlanDefinition.Action.Subject.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Subject =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.Subject {
    val __desc = descriptor
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        1 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding PlanDefinition.Action.Subject: " + __i
          )
      }
    }
    return PlanDefinition.Action.Subject.from(subjectCodeableConcept, subjectReference)!!
  }

  private object Hoisted {
    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object PlanDefinitionActionRelatedActionOffsetSerializer :
  KSerializer<PlanDefinition.Action.RelatedAction.Offset> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition.Action.RelatedAction.Offset") {
      element("offsetDuration", Duration.serializer().descriptor, isOptional = true)
      element("offsetRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction.Offset) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PlanDefinition.Action.RelatedAction.Offset.Duration -> {
          encodeSerializableElement(__desc, 0, Hoisted.offsetDurationSer, __d.value)
        }
        is PlanDefinition.Action.RelatedAction.Offset.Range -> {
          encodeSerializableElement(__desc, 1, Hoisted.offsetRangeSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction.Offset =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): PlanDefinition.Action.RelatedAction.Offset {
    val __desc = descriptor
    var offsetDuration: Duration? = null
    var offsetRange: Range? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          offsetDuration =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.offsetDurationSer, null)
        1 ->
          offsetRange =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.offsetRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding PlanDefinition.Action.RelatedAction.Offset: " + __i
          )
      }
    }
    return PlanDefinition.Action.RelatedAction.Offset.from(offsetDuration, offsetRange)!!
  }

  private object Hoisted {
    public val offsetDurationSer: KSerializer<Duration> = Duration.serializer()

    public val offsetRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object PlanDefinitionActionTimingSerializer : KSerializer<PlanDefinition.Action.Timing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition.Action.Timing") {
      element("timingDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
      element("timingAge", Age.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingDuration", Duration.serializer().descriptor, isOptional = true)
      element("timingRange", Range.serializer().descriptor, isOptional = true)
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Timing) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PlanDefinition.Action.Timing.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is PlanDefinition.Action.Timing.Age -> {
          encodeSerializableElement(__desc, 2, Hoisted.timingAgeSer, __d.value)
        }
        is PlanDefinition.Action.Timing.Period -> {
          encodeSerializableElement(__desc, 3, Hoisted.timingPeriodSer, __d.value)
        }
        is PlanDefinition.Action.Timing.Duration -> {
          encodeSerializableElement(__desc, 4, Hoisted.timingDurationSer, __d.value)
        }
        is PlanDefinition.Action.Timing.Range -> {
          encodeSerializableElement(__desc, 5, Hoisted.timingRangeSer, __d.value)
        }
        is PlanDefinition.Action.Timing.Timing -> {
          encodeSerializableElement(__desc, 6, Hoisted.timingTimingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Timing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.Timing {
    val __desc = descriptor
    var timingDateTime: KotlinString? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> timingDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          timingAge =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.timingAgeSer, null)
        3 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.timingPeriodSer, null)
        4 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.timingDurationSer, null)
        5 ->
          timingRange =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.timingRangeSer, null)
        6 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.timingTimingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding PlanDefinition.Action.Timing: " + __i
          )
      }
    }
    return PlanDefinition.Action.Timing.from(
      DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
      timingAge,
      timingPeriod,
      timingDuration,
      timingRange,
      timingTiming,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object PlanDefinitionActionDefinitionSerializer :
  KSerializer<PlanDefinition.Action.Definition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition.Action.Definition") {
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element("definitionUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionUri", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Definition) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PlanDefinition.Action.Definition.Canonical -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is PlanDefinition.Action.Definition.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Definition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): PlanDefinition.Action.Definition {
    val __desc = descriptor
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionUri: KotlinString? = null
    var _definitionUri: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> definitionCanonical = decoder.decodeStringElement(__desc, 0)
        1 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> definitionUri = decoder.decodeStringElement(__desc, 2)
        3 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding PlanDefinition.Action.Definition: " + __i
          )
      }
    }
    return PlanDefinition.Action.Definition.from(
      Canonical.of(definitionCanonical, _definitionCanonical),
      Uri.of(definitionUri, _definitionUri),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PlanDefinitionSerializer : KSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_subtitle", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("usage", KotlinString.serializer().descriptor, isOptional = true)
      element("_usage", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "topic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "author",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "editor",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewer",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endorser",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "library",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "goal",
        listSerialDescriptor(lazyDescriptor { PlanDefinition.Goal.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { PlanDefinition.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PlanDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): PlanDefinition {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var type: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var goal: List<PlanDefinition.Goal>? = null
    var action: List<PlanDefinition.Action>? = null
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> subtitle = decoder.decodeStringElement(__desc, 20)
        21 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> type = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.typeSer, null)
        23 -> status = decoder.decodeStringElement(__desc, 23)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.typeSer, null)
        28 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.subjectReferenceSer, null)
        29 -> date = decoder.decodeStringElement(__desc, 29)
        30 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> publisher = decoder.decodeStringElement(__desc, 31)
        32 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.contactSer, null)
        34 -> description = decoder.decodeStringElement(__desc, 34)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.useContextSer, null)
        37 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.jurisdictionSer, null)
        38 -> purpose = decoder.decodeStringElement(__desc, 38)
        39 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> usage = decoder.decodeStringElement(__desc, 40)
        41 ->
          _usage =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> copyright = decoder.decodeStringElement(__desc, 42)
        43 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> approvalDate = decoder.decodeStringElement(__desc, 44)
        45 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 -> lastReviewDate = decoder.decodeStringElement(__desc, 46)
        47 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.effectivePeriodSer, null)
        49 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.jurisdictionSer, null)
        50 ->
          author = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.contactSer, null)
        51 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.contactSer, null)
        52 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.contactSer, null)
        53 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.contactSer, null)
        54 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.relatedArtifactSer, null)
        55 ->
          library = decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.librarySer, null)
        56 ->
          _library =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.librarySer2, null)
        57 -> goal = decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.goalSer, null)
        58 ->
          action = decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PlanDefinition: " + __i)
      }
    }
    return PlanDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      subtitle = R4String.of(subtitle, _subtitle),
      type = type,
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = PlanDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { __i ->
          Canonical.of(library?.getOrNull(__i)?.let { it }, _library?.getOrNull(__i))!!
        }),
      goal = goal ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PlanDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "PlanDefinition")
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.typeSer, it) }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is PlanDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.typeSer, __d.value)
      }
      is PlanDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.usage?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 46, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        54,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 55, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.librarySer2, it)
    }
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 57, Hoisted.goalSer, value.goal)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 58, Hoisted.actionSer, value.action)
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val librarySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val librarySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.librarySerInner).nullable)

    public val librarySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val goalSerInner: KSerializer<PlanDefinition.Goal> = PlanDefinition.Goal.serializer()

    public val goalSer: KSerializer<List<PlanDefinition.Goal>> =
      ListSerializer(Hoisted.goalSerInner)

    public val actionSerInner: KSerializer<PlanDefinition.Action> =
      PlanDefinition.Action.serializer()

    public val actionSer: KSerializer<List<PlanDefinition.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}
