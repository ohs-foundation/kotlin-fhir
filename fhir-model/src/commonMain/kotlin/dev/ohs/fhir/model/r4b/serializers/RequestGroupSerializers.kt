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
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.RequestGroup
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
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

internal object RequestGroupActionSerializer : KSerializer<RequestGroup.Action> {
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
        "documentation",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "condition",
        listSerialDescriptor(
          lazyDescriptor { RequestGroup.Action.Condition.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "relatedAction",
        listSerialDescriptor(
          lazyDescriptor { RequestGroup.Action.RelatedAction.serializer().descriptor }
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
        listSerialDescriptor(Reference.serializer().descriptor),
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
      element("resource", Reference.serializer().descriptor, isOptional = true)
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { RequestGroup.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RequestGroup.Action =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestGroup.Action {
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
    var documentation: List<RelatedArtifact>? = null
    var condition: List<RequestGroup.Action.Condition>? = null
    var relatedAction: List<RequestGroup.Action.RelatedAction>? = null
    var timingDateTime: KotlinString? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var participant: List<Reference>? = null
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
    var resource: Reference? = null
    var action: List<RequestGroup.Action>? = null
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
        14 ->
          documentation =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.documentationSer, null)
        15 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.conditionSer, null)
        16 ->
          relatedAction =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.relatedActionSer, null)
        17 -> timingDateTime = decoder.decodeStringElement(__desc, 17)
        18 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.prefixSer, null)
        19 ->
          timingAge =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.timingAgeSer, null)
        20 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.timingPeriodSer, null)
        21 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.timingDurationSer, null)
        22 ->
          timingRange =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.timingRangeSer, null)
        23 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.timingTimingSer, null)
        24 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.participantSer, null)
        25 ->
          type = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.codeSerInner, null)
        26 -> groupingBehavior = decoder.decodeStringElement(__desc, 26)
        27 ->
          _groupingBehavior =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.prefixSer, null)
        28 -> selectionBehavior = decoder.decodeStringElement(__desc, 28)
        29 ->
          _selectionBehavior =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.prefixSer, null)
        30 -> requiredBehavior = decoder.decodeStringElement(__desc, 30)
        31 ->
          _requiredBehavior =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.prefixSer, null)
        32 -> precheckBehavior = decoder.decodeStringElement(__desc, 32)
        33 ->
          _precheckBehavior =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.prefixSer, null)
        34 -> cardinalityBehavior = decoder.decodeStringElement(__desc, 34)
        35 ->
          _cardinalityBehavior =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.prefixSer, null)
        36 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.participantSerInner, null)
        37 ->
          action = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
      }
    }
    return RequestGroup.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      prefix = R4bString.of(prefix, _prefix),
      title = R4bString.of(title, _title),
      description = R4bString.of(description, _description),
      textEquivalent = R4bString.of(textEquivalent, _textEquivalent),
      priority =
        priority?.let { Enumeration.of(RequestGroup.RequestPriority.fromCode(it), _priority) },
      code = code ?: listOf(),
      documentation = documentation ?: listOf(),
      condition = condition ?: listOf(),
      relatedAction = relatedAction ?: listOf(),
      timing =
        RequestGroup.Action.Timing.from(
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
          Enumeration.of(RequestGroup.ActionGroupingBehavior.fromCode(it), _groupingBehavior)
        },
      selectionBehavior =
        selectionBehavior?.let {
          Enumeration.of(RequestGroup.ActionSelectionBehavior.fromCode(it), _selectionBehavior)
        },
      requiredBehavior =
        requiredBehavior?.let {
          Enumeration.of(RequestGroup.ActionRequiredBehavior.fromCode(it), _requiredBehavior)
        },
      precheckBehavior =
        precheckBehavior?.let {
          Enumeration.of(RequestGroup.ActionPrecheckBehavior.fromCode(it), _precheckBehavior)
        },
      cardinalityBehavior =
        cardinalityBehavior?.let {
          Enumeration.of(RequestGroup.ActionCardinalityBehavior.fromCode(it), _cardinalityBehavior)
        },
      resource = resource,
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RequestGroup.Action) {
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
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.documentationSer, value.documentation)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.conditionSer, value.condition)
    if (value.relatedAction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.relatedActionSer, value.relatedAction)
    when (val __d = value.timing) {
      null -> {}
      is RequestGroup.Action.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.prefixSer, it)
        }
      }
      is RequestGroup.Action.Timing.Age -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.timingAgeSer, __d.value)
      }
      is RequestGroup.Action.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.timingPeriodSer, __d.value)
      }
      is RequestGroup.Action.Timing.Duration -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.timingDurationSer, __d.value)
      }
      is RequestGroup.Action.Timing.Range -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.timingRangeSer, __d.value)
      }
      is RequestGroup.Action.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.timingTimingSer, __d.value)
      }
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.participantSer, value.participant)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.codeSerInner, it) }
    ((value.groupingBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 26, it)
    }
    (value.groupingBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.prefixSer, it)
    }
    ((value.selectionBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 28, it)
    }
    (value.selectionBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.prefixSer, it)
    }
    ((value.requiredBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 30, it)
    }
    (value.requiredBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.prefixSer, it)
    }
    ((value.precheckBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 32, it)
    }
    (value.precheckBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.prefixSer, it)
    }
    ((value.cardinalityBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 34, it)
    }
    (value.cardinalityBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.prefixSer, it)
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.participantSerInner, it)
    }
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.actionSer, value.action)
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

    public val conditionSerInner: KSerializer<RequestGroup.Action.Condition> =
      RequestGroup.Action.Condition.serializer()

    public val conditionSer: KSerializer<List<RequestGroup.Action.Condition>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val relatedActionSerInner: KSerializer<RequestGroup.Action.RelatedAction> =
      RequestGroup.Action.RelatedAction.serializer()

    public val relatedActionSer: KSerializer<List<RequestGroup.Action.RelatedAction>> =
      ListSerializer(Hoisted.relatedActionSerInner)

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val participantSerInner: KSerializer<Reference> = Reference.serializer()

    public val participantSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.participantSerInner)

    public val actionSerInner: KSerializer<RequestGroup.Action> = RequestGroup.Action.serializer()

    public val actionSer: KSerializer<List<RequestGroup.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object RequestGroupActionConditionSerializer : KSerializer<RequestGroup.Action.Condition> {
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

  override fun deserialize(decoder: Decoder): RequestGroup.Action.Condition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.Condition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestGroup.Action.Condition {
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
    return RequestGroup.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind = Enumeration.of(RequestGroup.ActionConditionKind.fromCode(kind!!), _kind),
      expression = expression,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RequestGroup.Action.Condition) {
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

internal object RequestGroupActionRelatedActionSerializer :
  KSerializer<RequestGroup.Action.RelatedAction> {
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

  override fun deserialize(decoder: Decoder): RequestGroup.Action.RelatedAction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestGroup.Action.RelatedAction {
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
    return RequestGroup.Action.RelatedAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actionId = Id.of(actionId, _actionId)!!,
      relationship =
        Enumeration.of(RequestGroup.ActionRelationshipType.fromCode(relationship!!), _relationship),
      offset = RequestGroup.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RequestGroup.Action.RelatedAction) {
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
      is RequestGroup.Action.RelatedAction.Offset.Duration -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.offsetDurationSer, __d.value)
      }
      is RequestGroup.Action.RelatedAction.Offset.Range -> {
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

internal object RequestGroupSerializer : KSerializer<RequestGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestGroup") {
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
      element(
        "instantiatesCanonical",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("intent", KotlinString.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
      element("_authoredOn", Element.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { RequestGroup.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RequestGroup =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestGroup) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): RequestGroup {
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
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var authoredOn: KotlinString? = null
    var _authoredOn: Element? = null
    var author: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var action: List<RequestGroup.Action>? = null
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
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          replaces = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.identifierSerInner, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> intent = decoder.decodeStringElement(__desc, 21)
        22 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> priority = decoder.decodeStringElement(__desc, 23)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> code = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.codeSer, null)
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.basedOnSerInner, null)
        27 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.basedOnSerInner, null)
        28 -> authoredOn = decoder.decodeStringElement(__desc, 28)
        29 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          author =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.basedOnSerInner, null)
        31 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.reasonCodeSer, null)
        32 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.basedOnSer, null)
        33 -> note = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.noteSer, null)
        34 ->
          action = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RequestGroup: " + __i)
      }
    }
    return RequestGroup(
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
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      groupIdentifier = groupIdentifier,
      status = Enumeration.of(RequestGroup.RequestStatus.fromCode(status!!), _status),
      intent = Enumeration.of(RequestGroup.RequestIntent.fromCode(intent!!), _intent),
      priority =
        priority?.let { Enumeration.of(RequestGroup.RequestPriority.fromCode(it), _priority) },
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      author = author,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RequestGroup) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "RequestGroup")
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.replaces)
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.identifierSerInner, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.codeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.basedOnSerInner, it)
    }
    ((value.authoredOn?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.basedOnSerInner, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.reasonCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.basedOnSer, value.reasonReference)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.noteSer, value.note)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.actionSer, value.action)
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val actionSerInner: KSerializer<RequestGroup.Action> = RequestGroup.Action.serializer()

    public val actionSer: KSerializer<List<RequestGroup.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}
