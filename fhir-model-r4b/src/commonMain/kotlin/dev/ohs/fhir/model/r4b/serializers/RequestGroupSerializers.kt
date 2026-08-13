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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): RequestGroup.Action {
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
          documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentationSer, null)
        15 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        16 ->
          relatedAction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatedActionSer, null)
        17 -> timingDateTime = decoder.decodeStringElement(descriptor, i)
        18 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        19 ->
          timingAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingAgeSer, null)
        20 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingPeriodSer, null)
        21 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.timingDurationSer,
              null,
            )
        22 ->
          timingRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingRangeSer, null)
        23 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingTimingSer, null)
        24 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        25 ->
          type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSerInner, null)
        26 -> groupingBehavior = decoder.decodeStringElement(descriptor, i)
        27 ->
          _groupingBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        28 -> selectionBehavior = decoder.decodeStringElement(descriptor, i)
        29 ->
          _selectionBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        30 -> requiredBehavior = decoder.decodeStringElement(descriptor, i)
        31 ->
          _requiredBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        32 -> precheckBehavior = decoder.decodeStringElement(descriptor, i)
        33 ->
          _precheckBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        34 -> cardinalityBehavior = decoder.decodeStringElement(descriptor, i)
        35 ->
          _cardinalityBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prefixSer, null)
        36 ->
          resource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.participantSerInner,
              null,
            )
        37 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
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
          DateTime.of(timingDateTime?.let { FhirDateTime.fromString(it) }, _timingDateTime),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: RequestGroup.Action) {
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
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        Hoisted.documentationSer,
        value.documentation,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.conditionSer, value.condition)
    if (value.relatedAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        Hoisted.relatedActionSer,
        value.relatedAction,
      )
    when (val choice = value.timing) {
      null -> {}
      is RequestGroup.Action.Timing.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.prefixSer, it)
        }
      }
      is RequestGroup.Action.Timing.Age -> {
        encoder.encodeSerializableElement(descriptor, 19, Hoisted.timingAgeSer, choice.value)
      }
      is RequestGroup.Action.Timing.Period -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.timingPeriodSer, choice.value)
      }
      is RequestGroup.Action.Timing.Duration -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.timingDurationSer, choice.value)
      }
      is RequestGroup.Action.Timing.Range -> {
        encoder.encodeSerializableElement(descriptor, 22, Hoisted.timingRangeSer, choice.value)
      }
      is RequestGroup.Action.Timing.Timing -> {
        encoder.encodeSerializableElement(descriptor, 23, Hoisted.timingTimingSer, choice.value)
      }
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.participantSer, value.participant)
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.codeSerInner, it)
    }
    ((value.groupingBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 26, it)
    }
    (value.groupingBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.prefixSer, it)
    }
    ((value.selectionBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 28, it)
    }
    (value.selectionBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.prefixSer, it)
    }
    ((value.requiredBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 30, it)
    }
    (value.requiredBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.prefixSer, it)
    }
    ((value.precheckBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 32, it)
    }
    (value.precheckBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 33, Hoisted.prefixSer, it)
    }
    ((value.cardinalityBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 34, it)
    }
    (value.cardinalityBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 35, Hoisted.prefixSer, it)
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(descriptor, 36, Hoisted.participantSerInner, it)
    }
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 37, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.Condition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): RequestGroup.Action.Condition {
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
    return RequestGroup.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind =
        Enumeration.of(
          RequestGroup.ActionConditionKind.fromCode(
            kind
              ?: throw SerializationException(
                "Missing required property 'kind' on RequestGroup.Action.Condition"
              )
          ),
          _kind,
        ),
      expression = expression,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: RequestGroup.Action.Condition) {
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): RequestGroup.Action.RelatedAction {
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
    return RequestGroup.Action.RelatedAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actionId =
        Id.of(actionId, _actionId)
          ?: throw SerializationException(
            "Missing required property 'actionId' on RequestGroup.Action.RelatedAction"
          ),
      relationship =
        Enumeration.of(
          RequestGroup.ActionRelationshipType.fromCode(
            relationship
              ?: throw SerializationException(
                "Missing required property 'relationship' on RequestGroup.Action.RelatedAction"
              )
          ),
          _relationship,
        ),
      offset = RequestGroup.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: RequestGroup.Action.RelatedAction,
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
      is RequestGroup.Action.RelatedAction.Offset.Duration -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.offsetDurationSer, choice.value)
      }
      is RequestGroup.Action.RelatedAction.Offset.Range -> {
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

internal object RequestGroupSerializer : KSerializer<RequestGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestGroup") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "replaces",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("groupIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element("priority", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("authoredOn", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_authoredOn", Element.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
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
      "action",
      listSerialDescriptor(lazyDescriptor { RequestGroup.Action.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): RequestGroup =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "RequestGroup")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): RequestGroup {
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
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        17 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> priority = decoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        25 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        26 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        27 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        28 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSerInner, null)
        30 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonCodeSer, null)
        31 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        32 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        33 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        else -> throw SerializationException("Unexpected index decoding RequestGroup: " + i)
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
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(
          RequestGroup.RequestStatus.fromCode(
            status
              ?: throw SerializationException("Missing required property 'status' on RequestGroup")
          ),
          _status,
        ),
      intent =
        Enumeration.of(
          RequestGroup.RequestIntent.fromCode(
            intent
              ?: throw SerializationException("Missing required property 'intent' on RequestGroup")
          ),
          _intent,
        ),
      priority =
        priority?.let { Enumeration.of(RequestGroup.RequestPriority.fromCode(it), _priority) },
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn = DateTime.of(authoredOn?.let { FhirDateTime.fromString(it) }, _authoredOn),
      author = author,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      action = action ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RequestGroup,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.basedOnSer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.basedOnSer,
        value.replaces,
      )
    (value.groupIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.intent.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.codeSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    ((value.authoredOn?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.authoredOn?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.basedOnSerInner,
        it,
      )
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.reasonCodeSer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.basedOnSer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
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

internal object RequestGroupPolymorphicSerializer : KSerializer<RequestGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestGroup") { RequestGroupSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: RequestGroup) {
    encoder.encodeStructure(descriptor) {
      RequestGroupSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): RequestGroup =
    decoder.decodeStructure(descriptor) {
      RequestGroupSerializer.deserializeInternal(this, descriptor, 0)
    }
}
