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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Goal {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 ->
          priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        6 ->
          start =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        7 ->
          addresses =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressesSer, null)
        8 ->
          documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentationSer, null)
        9 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Goal: " + i)
      }
    }
    return PlanDefinition.Goal(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      description =
        description
          ?: throw SerializationException(
            "Missing required property 'description' on PlanDefinition.Goal"
          ),
      priority = priority,
      start = start,
      addresses = addresses ?: listOf(),
      documentation = documentation ?: listOf(),
      target = target ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Goal) {
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
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, value.description)
    (value.priority)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.categorySer, it)
    }
    (value.start)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.categorySer, it) }
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.addressesSer, value.addresses)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        Hoisted.documentationSer,
        value.documentation,
      )
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.targetSer, value.target)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Goal.Target {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var measure: CodeableConcept? = null
    var detailQuantity: Quantity? = null
    var detailRange: Range? = null
    var detailCodeableConcept: CodeableConcept? = null
    var due: Duration? = null
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
        7 -> due = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Goal.Target) {
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
      is PlanDefinition.Goal.Target.Detail.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.detailQuantitySer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.Range -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.detailRangeSer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.measureSer, choice.value)
      }
    }
    (value.due)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.dueSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> prefix = decoder.decodeStringElement(descriptor, i)
        4 ->
          _prefix =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        5 -> title = decoder.decodeStringElement(descriptor, i)
        6 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        7 -> description = decoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        9 -> textEquivalent = decoder.decodeStringElement(descriptor, i)
        10 ->
          _textEquivalent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        11 -> priority = decoder.decodeStringElement(descriptor, i)
        12 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        13 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        14 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        15 ->
          documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentationSer, null)
        16 ->
          goalId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.goalIdSer, null)
        17 ->
          _goalId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.goalIdSer2, null)
        18 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSerInner, null)
        19 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        20 ->
          trigger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.triggerSer, null)
        21 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        22 ->
          input = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.inputSer, null)
        23 ->
          output = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.inputSer, null)
        24 ->
          relatedAction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatedActionSer, null)
        25 -> timingDateTime = decoder.decodeStringElement(descriptor, i)
        26 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        27 ->
          timingAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingAgeSer, null)
        28 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingPeriodSer, null)
        29 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.timingDurationSer,
              null,
            )
        30 ->
          timingRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingRangeSer, null)
        31 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingTimingSer, null)
        32 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        33 ->
          type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSerInner, null)
        34 -> groupingBehavior = decoder.decodeStringElement(descriptor, i)
        35 ->
          _groupingBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        36 -> selectionBehavior = decoder.decodeStringElement(descriptor, i)
        37 ->
          _selectionBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        38 -> requiredBehavior = decoder.decodeStringElement(descriptor, i)
        39 ->
          _requiredBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        40 -> precheckBehavior = decoder.decodeStringElement(descriptor, i)
        41 ->
          _precheckBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        42 -> cardinalityBehavior = decoder.decodeStringElement(descriptor, i)
        43 ->
          _cardinalityBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        44 -> definitionCanonical = decoder.decodeStringElement(descriptor, i)
        45 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        46 -> definitionUri = decoder.decodeStringElement(descriptor, i)
        47 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        48 -> transform = decoder.decodeStringElement(descriptor, i)
        49 ->
          _transform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        50 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dynamicValueSer, null)
        51 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
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
        (kotlin.collections.List(maxOf(goalId?.size ?: 0, _goalId?.size ?: 0)) { index ->
          Id.of(goalId?.getOrNull(index)?.let { it }, _goalId?.getOrNull(index))!!
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Action) {
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
    ((value.prefix?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.prefix?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.prefixSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.prefixSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.prefixSer, it)
    }
    ((value.textEquivalent?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.textEquivalent?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.prefixSer, it)
    }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.prefixSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.codeSer, value.code)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.codeSer, value.reason)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        Hoisted.documentationSer,
        value.documentation,
      )
    (value.goalId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.goalIdSer, it)
    }
    (value.goalId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.goalIdSer2, it)
    }
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Action.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 18, Hoisted.codeSerInner, choice.value)
      }
      is PlanDefinition.Action.Subject.Reference -> {
        encoder.encodeSerializableElement(descriptor, 19, Hoisted.subjectReferenceSer, choice.value)
      }
    }
    if (value.trigger.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.triggerSer, value.trigger)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.conditionSer, value.condition)
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.inputSer, value.output)
    if (value.relatedAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24,
        Hoisted.relatedActionSer,
        value.relatedAction,
      )
    when (val choice = value.timing) {
      null -> {}
      is PlanDefinition.Action.Timing.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 25, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 26, Hoisted.prefixSer, it)
        }
      }
      is PlanDefinition.Action.Timing.Age -> {
        encoder.encodeSerializableElement(descriptor, 27, Hoisted.timingAgeSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Period -> {
        encoder.encodeSerializableElement(descriptor, 28, Hoisted.timingPeriodSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Duration -> {
        encoder.encodeSerializableElement(descriptor, 29, Hoisted.timingDurationSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Range -> {
        encoder.encodeSerializableElement(descriptor, 30, Hoisted.timingRangeSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Timing -> {
        encoder.encodeSerializableElement(descriptor, 31, Hoisted.timingTimingSer, choice.value)
      }
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.participantSer, value.participant)
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 33, Hoisted.codeSerInner, it)
    }
    ((value.groupingBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 34, it)
    }
    (value.groupingBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 35, Hoisted.prefixSer, it)
    }
    ((value.selectionBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 36, it)
    }
    (value.selectionBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 37, Hoisted.prefixSer, it)
    }
    ((value.requiredBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 38, it)
    }
    (value.requiredBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 39, Hoisted.prefixSer, it)
    }
    ((value.precheckBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 40, it)
    }
    (value.precheckBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 41, Hoisted.prefixSer, it)
    }
    ((value.cardinalityBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 42, it)
    }
    (value.cardinalityBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 43, Hoisted.prefixSer, it)
    }
    when (val choice = value.definition) {
      null -> {}
      is PlanDefinition.Action.Definition.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 44, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 45, Hoisted.prefixSer, it)
        }
      }
      is PlanDefinition.Action.Definition.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 46, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 47, Hoisted.prefixSer, it)
        }
      }
    }
    ((value.transform?.value))?.let { encoder.encodeStringElement(descriptor, 48, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 49, Hoisted.prefixSer, it)
    }
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 50, Hoisted.dynamicValueSer, value.dynamicValue)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 51, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Condition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.Condition {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> kind = decoder.decodeStringElement(descriptor, i)
        4 -> _kind = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kindSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Condition: " + i)
      }
    }
    return PlanDefinition.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind =
        Enumeration.of(
          PlanDefinition.ActionConditionKind.fromCode(
            kind
              ?: throw SerializationException(
                "Missing required property 'kind' on PlanDefinition.Action.Condition"
              )
          ),
          _kind,
        ),
      expression = expression,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.Condition,
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
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.kindSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.expressionSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.RelatedAction {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> actionId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _actionId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionIdSer, null)
        5 -> relationship = decoder.decodeStringElement(descriptor, i)
        6 ->
          _relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionIdSer, null)
        7 ->
          offsetDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.offsetDurationSer,
              null,
            )
        8 ->
          offsetRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.offsetRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAction: " + i)
      }
    }
    return PlanDefinition.Action.RelatedAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actionId =
        Id.of(actionId, _actionId)
          ?: throw SerializationException(
            "Missing required property 'actionId' on PlanDefinition.Action.RelatedAction"
          ),
      relationship =
        Enumeration.of(
          PlanDefinition.ActionRelationshipType.fromCode(
            relationship
              ?: throw SerializationException(
                "Missing required property 'relationship' on PlanDefinition.Action.RelatedAction"
              )
          ),
          _relationship,
        ),
      offset = PlanDefinition.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.RelatedAction,
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
    ((value.actionId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.actionId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.actionIdSer, it)
    }
    ((value.relationship.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.relationship.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.actionIdSer, it)
    }
    when (val choice = value.offset) {
      null -> {}
      is PlanDefinition.Action.RelatedAction.Offset.Duration -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.offsetDurationSer, choice.value)
      }
      is PlanDefinition.Action.RelatedAction.Offset.Range -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.offsetRangeSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.Participant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return PlanDefinition.Action.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          PlanDefinition.ActionParticipantType.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on PlanDefinition.Action.Participant"
              )
          ),
          _type,
        ),
      role = role,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.Participant,
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.roleSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.DynamicValue) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.DynamicValue {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(descriptor, i)
        4 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.DynamicValue,
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
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.pathSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.expressionSer, it)
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

internal object PlanDefinitionSerializer : KSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subtitle", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("usage", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_usage", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "topic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "library",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "goal",
      listSerialDescriptor(lazyDescriptor { PlanDefinition.Goal.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "action",
      listSerialDescriptor(lazyDescriptor { PlanDefinition.Action.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): PlanDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PlanDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PlanDefinition {
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> subtitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        27 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        37 -> purpose = decoder.decodeStringElement(descriptor, i)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> usage = decoder.decodeStringElement(descriptor, i)
        40 ->
          _usage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> copyright = decoder.decodeStringElement(descriptor, i)
        42 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        48 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        49 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        50 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        51 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        52 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        53 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        54 ->
          library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer, null)
        55 ->
          _library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer2, null)
        56 -> goal = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.goalSer, null)
        57 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        else -> throw SerializationException("Unexpected index decoding PlanDefinition: " + i)
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
      status =
        Enumeration.of(
          PublicationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on PlanDefinition"
              )
          ),
          _status,
        ),
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
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index)?.let { it }, _library?.getOrNull(index))!!
        }),
      goal = goal ?: listOf(),
      action = action ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PlanDefinition,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.subtitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          Hoisted.typeSer,
          choice.value,
        )
      }
      is PlanDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          Hoisted.subjectReferenceSer,
          choice.value,
        )
      }
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.usage?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 45 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 54 + descriptorOffset, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 55 + descriptorOffset, Hoisted.librarySer2, it)
    }
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.goalSer,
        value.goal,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.actionSer,
        value.action,
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

internal object PlanDefinitionPolymorphicSerializer : KSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition") { PlanDefinitionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition) {
    encoder.encodeStructure(descriptor) {
      PlanDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition =
    decoder.decodeStructure(descriptor) {
      PlanDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
