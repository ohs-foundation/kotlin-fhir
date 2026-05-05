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
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.RequestOrchestration
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
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

internal object RequestOrchestrationActionSerializer : KSerializer<RequestOrchestration.Action> {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
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
      element("goal", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "condition",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.Condition.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "input",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.Input.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "output",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.Output.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "relatedAction",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.RelatedAction.serializer().descriptor }
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
      element("location", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.Participant.serializer().descriptor }
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
      element("resource", Reference.serializer().descriptor, isOptional = true)
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element("definitionUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionUri", Element.serializer().descriptor, isOptional = true)
      element("transform", KotlinString.serializer().descriptor, isOptional = true)
      element("_transform", Element.serializer().descriptor, isOptional = true)
      element(
        "dynamicValue",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.DynamicValue.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(
          lazyDescriptor { RequestOrchestration.Action.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
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
    var goal: List<Reference>? = null
    var condition: List<RequestOrchestration.Action.Condition>? = null
    var input: List<RequestOrchestration.Action.Input>? = null
    var output: List<RequestOrchestration.Action.Output>? = null
    var relatedAction: List<RequestOrchestration.Action.RelatedAction>? = null
    var timingDateTime: KotlinString? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var location: CodeableReference? = null
    var participant: List<RequestOrchestration.Action.Participant>? = null
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
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionUri: KotlinString? = null
    var _definitionUri: Element? = null
    var transform: KotlinString? = null
    var _transform: Element? = null
    var dynamicValue: List<RequestOrchestration.Action.DynamicValue>? = null
    var action: List<RequestOrchestration.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> prefix = decoder.decodeStringElement(__desc, 5)
        6 -> _prefix = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.linkIdSer, null)
        7 -> title = decoder.decodeStringElement(__desc, 7)
        8 -> _title = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.linkIdSer, null)
        9 -> description = decoder.decodeStringElement(__desc, 9)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.linkIdSer, null)
        11 -> textEquivalent = decoder.decodeStringElement(__desc, 11)
        12 ->
          _textEquivalent =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.linkIdSer, null)
        13 -> priority = decoder.decodeStringElement(__desc, 13)
        14 ->
          _priority = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.linkIdSer, null)
        15 -> code = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.codeSer, null)
        16 ->
          documentation =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.documentationSer, null)
        17 -> goal = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.goalSer, null)
        18 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.conditionSer, null)
        19 -> input = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.inputSer, null)
        20 ->
          output = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.outputSer, null)
        21 ->
          relatedAction =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.relatedActionSer, null)
        22 -> timingDateTime = decoder.decodeStringElement(__desc, 22)
        23 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.linkIdSer, null)
        24 ->
          timingAge =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.timingAgeSer, null)
        25 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.timingPeriodSer, null)
        26 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.timingDurationSer, null)
        27 ->
          timingRange =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.timingRangeSer, null)
        28 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.timingTimingSer, null)
        29 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.locationSer, null)
        30 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.participantSer, null)
        31 ->
          type = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.codeSerInner, null)
        32 -> groupingBehavior = decoder.decodeStringElement(__desc, 32)
        33 ->
          _groupingBehavior =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.linkIdSer, null)
        34 -> selectionBehavior = decoder.decodeStringElement(__desc, 34)
        35 ->
          _selectionBehavior =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.linkIdSer, null)
        36 -> requiredBehavior = decoder.decodeStringElement(__desc, 36)
        37 ->
          _requiredBehavior =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.linkIdSer, null)
        38 -> precheckBehavior = decoder.decodeStringElement(__desc, 38)
        39 ->
          _precheckBehavior =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.linkIdSer, null)
        40 -> cardinalityBehavior = decoder.decodeStringElement(__desc, 40)
        41 ->
          _cardinalityBehavior =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.linkIdSer, null)
        42 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.goalSerInner, null)
        43 -> definitionCanonical = decoder.decodeStringElement(__desc, 43)
        44 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.linkIdSer, null)
        45 -> definitionUri = decoder.decodeStringElement(__desc, 45)
        46 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.linkIdSer, null)
        47 -> transform = decoder.decodeStringElement(__desc, 47)
        48 ->
          _transform =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.linkIdSer, null)
        49 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.dynamicValueSer, null)
        50 ->
          action = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
      }
    }
    return RequestOrchestration.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R5String.of(linkId, _linkId),
      prefix = R5String.of(prefix, _prefix),
      title = R5String.of(title, _title),
      description = Markdown.of(description, _description),
      textEquivalent = Markdown.of(textEquivalent, _textEquivalent),
      priority =
        priority?.let {
          Enumeration.of(RequestOrchestration.RequestPriority.fromCode(it), _priority)
        },
      code = code ?: listOf(),
      documentation = documentation ?: listOf(),
      goal = goal ?: listOf(),
      condition = condition ?: listOf(),
      input = input ?: listOf(),
      output = output ?: listOf(),
      relatedAction = relatedAction ?: listOf(),
      timing =
        RequestOrchestration.Action.Timing.from(
          DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
          timingAge,
          timingPeriod,
          timingDuration,
          timingRange,
          timingTiming,
        ),
      location = location,
      participant = participant ?: listOf(),
      type = type,
      groupingBehavior =
        groupingBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionGroupingBehavior.fromCode(it),
            _groupingBehavior,
          )
        },
      selectionBehavior =
        selectionBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionSelectionBehavior.fromCode(it),
            _selectionBehavior,
          )
        },
      requiredBehavior =
        requiredBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionRequiredBehavior.fromCode(it),
            _requiredBehavior,
          )
        },
      precheckBehavior =
        precheckBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionPrecheckBehavior.fromCode(it),
            _precheckBehavior,
          )
        },
      cardinalityBehavior =
        cardinalityBehavior?.let {
          Enumeration.of(
            RequestOrchestration.ActionCardinalityBehavior.fromCode(it),
            _cardinalityBehavior,
          )
        },
      resource = resource,
      definition =
        RequestOrchestration.Action.Definition.from(
          Canonical.of(definitionCanonical, _definitionCanonical),
          Uri.of(definitionUri, _definitionUri),
        ),
      transform = Canonical.of(transform, _transform),
      dynamicValue = dynamicValue ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RequestOrchestration.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    ((value.prefix?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.prefix?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.linkIdSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.linkIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.linkIdSer, it)
    }
    ((value.textEquivalent?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.textEquivalent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.linkIdSer, it)
    }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.linkIdSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.codeSer, value.code)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.documentationSer, value.documentation)
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.goalSer, value.goal)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.conditionSer, value.condition)
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.outputSer, value.output)
    if (value.relatedAction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.relatedActionSer, value.relatedAction)
    when (val __d = value.timing) {
      null -> {}
      is RequestOrchestration.Action.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.linkIdSer, it)
        }
      }
      is RequestOrchestration.Action.Timing.Age -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.timingAgeSer, __d.value)
      }
      is RequestOrchestration.Action.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.timingPeriodSer, __d.value)
      }
      is RequestOrchestration.Action.Timing.Duration -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.timingDurationSer, __d.value)
      }
      is RequestOrchestration.Action.Timing.Range -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.timingRangeSer, __d.value)
      }
      is RequestOrchestration.Action.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.timingTimingSer, __d.value)
      }
    }
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.locationSer, it) }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.participantSer, value.participant)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 31, Hoisted.codeSerInner, it) }
    ((value.groupingBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 32, it)
    }
    (value.groupingBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.linkIdSer, it)
    }
    ((value.selectionBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 34, it)
    }
    (value.selectionBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.linkIdSer, it)
    }
    ((value.requiredBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 36, it)
    }
    (value.requiredBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.linkIdSer, it)
    }
    ((value.precheckBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 38, it)
    }
    (value.precheckBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.linkIdSer, it)
    }
    ((value.cardinalityBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 40, it)
    }
    (value.cardinalityBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.linkIdSer, it)
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.goalSerInner, it)
    }
    when (val __d = value.definition) {
      null -> {}
      is RequestOrchestration.Action.Definition.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 43, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 44, Hoisted.linkIdSer, it)
        }
      }
      is RequestOrchestration.Action.Definition.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 45, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 46, Hoisted.linkIdSer, it)
        }
      }
    }
    ((value.transform?.value))?.let { encoder.encodeStringElement(__desc, 47, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.linkIdSer, it)
    }
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.dynamicValueSer, value.dynamicValue)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val documentationSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val documentationSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.documentationSerInner)

    public val goalSerInner: KSerializer<Reference> = Reference.serializer()

    public val goalSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.goalSerInner)

    public val conditionSerInner: KSerializer<RequestOrchestration.Action.Condition> =
      RequestOrchestration.Action.Condition.serializer()

    public val conditionSer: KSerializer<List<RequestOrchestration.Action.Condition>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val inputSerInner: KSerializer<RequestOrchestration.Action.Input> =
      RequestOrchestration.Action.Input.serializer()

    public val inputSer: KSerializer<List<RequestOrchestration.Action.Input>> =
      ListSerializer(Hoisted.inputSerInner)

    public val outputSerInner: KSerializer<RequestOrchestration.Action.Output> =
      RequestOrchestration.Action.Output.serializer()

    public val outputSer: KSerializer<List<RequestOrchestration.Action.Output>> =
      ListSerializer(Hoisted.outputSerInner)

    public val relatedActionSerInner: KSerializer<RequestOrchestration.Action.RelatedAction> =
      RequestOrchestration.Action.RelatedAction.serializer()

    public val relatedActionSer: KSerializer<List<RequestOrchestration.Action.RelatedAction>> =
      ListSerializer(Hoisted.relatedActionSerInner)

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val locationSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val participantSerInner: KSerializer<RequestOrchestration.Action.Participant> =
      RequestOrchestration.Action.Participant.serializer()

    public val participantSer: KSerializer<List<RequestOrchestration.Action.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val dynamicValueSerInner: KSerializer<RequestOrchestration.Action.DynamicValue> =
      RequestOrchestration.Action.DynamicValue.serializer()

    public val dynamicValueSer: KSerializer<List<RequestOrchestration.Action.DynamicValue>> =
      ListSerializer(Hoisted.dynamicValueSerInner)

    public val actionSerInner: KSerializer<RequestOrchestration.Action> =
      RequestOrchestration.Action.serializer()

    public val actionSer: KSerializer<List<RequestOrchestration.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object RequestOrchestrationActionConditionSerializer :
  KSerializer<RequestOrchestration.Action.Condition> {
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Condition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Condition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration.Action.Condition {
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
    return RequestOrchestration.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind = Enumeration.of(RequestOrchestration.ActionConditionKind.fromCode(kind!!), _kind),
      expression = expression,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RequestOrchestration.Action.Condition,
  ) {
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

internal object RequestOrchestrationActionInputSerializer :
  KSerializer<RequestOrchestration.Action.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("requirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("relatedData", KotlinString.serializer().descriptor, isOptional = true)
      element("_relatedData", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Input =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Input) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration.Action.Input {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var requirement: DataRequirement? = null
    var relatedData: KotlinString? = null
    var _relatedData: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(__desc, 3)
        4 -> _title = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.titleSer, null)
        5 ->
          requirement =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.requirementSer, null)
        6 -> relatedData = decoder.decodeStringElement(__desc, 6)
        7 ->
          _relatedData =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.titleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + __i)
      }
    }
    return RequestOrchestration.Action.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = Id.of(relatedData, _relatedData),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RequestOrchestration.Action.Input) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.titleSer, it)
    }
    (value.requirement)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.requirementSer, it)
    }
    ((value.relatedData?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.relatedData?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.titleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val requirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()
  }
}

internal object RequestOrchestrationActionOutputSerializer :
  KSerializer<RequestOrchestration.Action.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("requirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("relatedData", KotlinString.serializer().descriptor, isOptional = true)
      element("_relatedData", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Output =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Output) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration.Action.Output {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var requirement: DataRequirement? = null
    var relatedData: KotlinString? = null
    var _relatedData: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(__desc, 3)
        4 -> _title = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.titleSer, null)
        5 ->
          requirement =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.requirementSer, null)
        6 -> relatedData = decoder.decodeStringElement(__desc, 6)
        7 ->
          _relatedData =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.titleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Output: " + __i)
      }
    }
    return RequestOrchestration.Action.Output(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = R5String.of(relatedData, _relatedData),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RequestOrchestration.Action.Output,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.titleSer, it)
    }
    (value.requirement)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.requirementSer, it)
    }
    ((value.relatedData?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.relatedData?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.titleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val requirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()
  }
}

internal object RequestOrchestrationActionRelatedActionSerializer :
  KSerializer<RequestOrchestration.Action.RelatedAction> {
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
      element("targetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetId", Element.serializer().descriptor, isOptional = true)
      element("relationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_relationship", Element.serializer().descriptor, isOptional = true)
      element("endRelationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_endRelationship", Element.serializer().descriptor, isOptional = true)
      element("offsetDuration", Duration.serializer().descriptor, isOptional = true)
      element("offsetRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.RelatedAction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): RequestOrchestration.Action.RelatedAction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var targetId: KotlinString? = null
    var _targetId: Element? = null
    var relationship: KotlinString? = null
    var _relationship: Element? = null
    var endRelationship: KotlinString? = null
    var _endRelationship: Element? = null
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
        3 -> targetId = decoder.decodeStringElement(__desc, 3)
        4 ->
          _targetId =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.targetIdSer, null)
        5 -> relationship = decoder.decodeStringElement(__desc, 5)
        6 ->
          _relationship =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.targetIdSer, null)
        7 -> endRelationship = decoder.decodeStringElement(__desc, 7)
        8 ->
          _endRelationship =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.targetIdSer, null)
        9 ->
          offsetDuration =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.offsetDurationSer, null)
        10 ->
          offsetRange =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.offsetRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAction: " + __i)
      }
    }
    return RequestOrchestration.Action.RelatedAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      targetId = Id.of(targetId, _targetId)!!,
      relationship =
        Enumeration.of(
          RequestOrchestration.ActionRelationshipType.fromCode(relationship!!),
          _relationship,
        ),
      endRelationship =
        endRelationship?.let {
          Enumeration.of(RequestOrchestration.ActionRelationshipType.fromCode(it), _endRelationship)
        },
      offset = RequestOrchestration.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RequestOrchestration.Action.RelatedAction,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.targetId.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.targetId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.targetIdSer, it)
    }
    ((value.relationship.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.relationship.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.targetIdSer, it)
    }
    ((value.endRelationship?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.endRelationship?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.targetIdSer, it)
    }
    when (val __d = value.offset) {
      null -> {}
      is RequestOrchestration.Action.RelatedAction.Offset.Duration -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.offsetDurationSer, __d.value)
      }
      is RequestOrchestration.Action.RelatedAction.Offset.Range -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.offsetRangeSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val targetIdSer: KSerializer<Element> = Element.serializer()

    public val offsetDurationSer: KSerializer<Duration> = Duration.serializer()

    public val offsetRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object RequestOrchestrationActionParticipantSerializer :
  KSerializer<RequestOrchestration.Action.Participant> {
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
      element("typeCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_typeCanonical", Element.serializer().descriptor, isOptional = true)
      element("typeReference", Reference.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actorCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_actorCanonical", Element.serializer().descriptor, isOptional = true)
      element("actorReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration.Action.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var typeCanonical: KotlinString? = null
    var _typeCanonical: Element? = null
    var typeReference: Reference? = null
    var role: CodeableConcept? = null
    var function: CodeableConcept? = null
    var actorCanonical: KotlinString? = null
    var _actorCanonical: Element? = null
    var actorReference: Reference? = null
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
        5 -> typeCanonical = decoder.decodeStringElement(__desc, 5)
        6 ->
          _typeCanonical =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          typeReference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeReferenceSer, null)
        8 -> role = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.roleSer, null)
        9 -> function = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.roleSer, null)
        10 -> actorCanonical = decoder.decodeStringElement(__desc, 10)
        11 ->
          _actorCanonical =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.typeSer, null)
        12 ->
          actorReference =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.typeReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return RequestOrchestration.Action.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type?.let {
          Enumeration.of(RequestOrchestration.ActionParticipantType.fromCode(it), _type)
        },
      typeCanonical = Canonical.of(typeCanonical, _typeCanonical),
      typeReference = typeReference,
      role = role,
      function = function,
      actor =
        RequestOrchestration.Action.Participant.Actor.from(
          Canonical.of(actorCanonical, _actorCanonical),
          actorReference,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RequestOrchestration.Action.Participant,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.typeCanonical?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.typeCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    (value.typeReference)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeReferenceSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.roleSer, it) }
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.roleSer, it) }
    when (val __d = value.actor) {
      null -> {}
      is RequestOrchestration.Action.Participant.Actor.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.typeSer, it)
        }
      }
      is RequestOrchestration.Action.Participant.Actor.Reference -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.typeReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val typeReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object RequestOrchestrationActionDynamicValueSerializer :
  KSerializer<RequestOrchestration.Action.DynamicValue> {
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

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.DynamicValue =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.DynamicValue) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration.Action.DynamicValue {
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
    return RequestOrchestration.Action.DynamicValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R5String.of(path, _path),
      expression = expression,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RequestOrchestration.Action.DynamicValue,
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

internal object RequestOrchestrationSerializer : KSerializer<RequestOrchestration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestOrchestration") {
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
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("goal", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "action",
      listSerialDescriptor(lazyDescriptor { RequestOrchestration.Action.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "RequestOrchestration")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): RequestOrchestration {
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
    var reason: List<CodeableReference>? = null
    var goal: List<Reference>? = null
    var note: List<Annotation>? = null
    var action: List<RequestOrchestration.Action>? = null
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
          reason = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.reasonSer, null)
        32 -> goal = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.basedOnSer, null)
        33 -> note = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.noteSer, null)
        34 ->
          action = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RequestOrchestration: " + __i)
      }
    }
    return RequestOrchestration(
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
      status = Enumeration.of(RequestOrchestration.RequestStatus.fromCode(status!!), _status),
      intent = Enumeration.of(RequestOrchestration.RequestIntent.fromCode(intent!!), _intent),
      priority =
        priority?.let {
          Enumeration.of(RequestOrchestration.RequestPriority.fromCode(it), _priority)
        },
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn = DateTime.of(FhirDateTime.fromString(authoredOn), _authoredOn),
      author = author,
      reason = reason ?: listOf(),
      goal = goal ?: listOf(),
      note = note ?: listOf(),
      action = action ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: RequestOrchestration) {
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
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.reasonSer, value.reason)
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.basedOnSer, value.goal)
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

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val actionSerInner: KSerializer<RequestOrchestration.Action> =
      RequestOrchestration.Action.serializer()

    public val actionSer: KSerializer<List<RequestOrchestration.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object RequestOrchestrationPolymorphicSerializer : KSerializer<RequestOrchestration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RequestOrchestration") {
      RequestOrchestrationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration) {
    encoder.encodeStructure(descriptor) {
      RequestOrchestrationSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration =
    decoder.decodeStructure(descriptor) { RequestOrchestrationSerializer.deserializeJson(this) }
}
