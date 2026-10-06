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
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
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
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("prefix", KotlinString.serializer().descriptor)
      optionalElement("_prefix", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("textEquivalent", KotlinString.serializer().descriptor)
      optionalElement("_textEquivalent", ElementSerializer.descriptor)
      optionalElement("priority", KotlinString.serializer().descriptor)
      optionalElement("_priority", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("documentation", RelatedArtifactSerializer.listSerializer.descriptor)
      optionalElement("condition", RequestGroupActionConditionSerializer.listSerializer.descriptor)
      optionalElement(
        "relatedAction",
        RequestGroupActionRelatedActionSerializer.listSerializer.descriptor,
      )
      optionalElement("timingDateTime", KotlinString.serializer().descriptor)
      optionalElement("_timingDateTime", ElementSerializer.descriptor)
      optionalElement("timingAge", AgeSerializer.descriptor)
      optionalElement("timingPeriod", PeriodSerializer.descriptor)
      optionalElement("timingDuration", DurationSerializer.descriptor)
      optionalElement("timingRange", RangeSerializer.descriptor)
      optionalElement("timingTiming", TimingSerializer.descriptor)
      optionalElement("participant", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("groupingBehavior", KotlinString.serializer().descriptor)
      optionalElement("_groupingBehavior", ElementSerializer.descriptor)
      optionalElement("selectionBehavior", KotlinString.serializer().descriptor)
      optionalElement("_selectionBehavior", ElementSerializer.descriptor)
      optionalElement("requiredBehavior", KotlinString.serializer().descriptor)
      optionalElement("_requiredBehavior", ElementSerializer.descriptor)
      optionalElement("precheckBehavior", KotlinString.serializer().descriptor)
      optionalElement("_precheckBehavior", ElementSerializer.descriptor)
      optionalElement("cardinalityBehavior", KotlinString.serializer().descriptor)
      optionalElement("_cardinalityBehavior", ElementSerializer.descriptor)
      optionalElement("resource", ReferenceSerializer.descriptor)
      optionalElement(
        "action",
        listSerialDescriptor(lazyDescriptor { RequestGroupActionSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<RequestGroup.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestGroup.Action =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> prefix = decodeStringElement(descriptor, i)
          4 -> _prefix = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> title = decodeStringElement(descriptor, i)
          6 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> description = decodeStringElement(descriptor, i)
          8 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> textEquivalent = decodeStringElement(descriptor, i)
          10 ->
            _textEquivalent =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> priority = decodeStringElement(descriptor, i)
          12 ->
            _priority = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          14 ->
            documentation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RelatedArtifactSerializer.listSerializer,
                null,
              )
          15 ->
            condition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestGroupActionConditionSerializer.listSerializer,
                null,
              )
          16 ->
            relatedAction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestGroupActionRelatedActionSerializer.listSerializer,
                null,
              )
          17 -> timingDateTime = decodeStringElement(descriptor, i)
          18 ->
            _timingDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> timingAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          20 ->
            timingPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          21 ->
            timingDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          22 ->
            timingRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          23 ->
            timingTiming = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          24 ->
            participant =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          25 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          26 -> groupingBehavior = decodeStringElement(descriptor, i)
          27 ->
            _groupingBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 -> selectionBehavior = decodeStringElement(descriptor, i)
          29 ->
            _selectionBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          30 -> requiredBehavior = decodeStringElement(descriptor, i)
          31 ->
            _requiredBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          32 -> precheckBehavior = decodeStringElement(descriptor, i)
          33 ->
            _precheckBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          34 -> cardinalityBehavior = decodeStringElement(descriptor, i)
          35 ->
            _cardinalityBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          36 ->
            resource = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          37 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                RequestGroupActionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      RequestGroup.Action(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        prefix = R4bString.of(prefix, _prefix),
        title = R4bString.of(title, _title),
        description = R4bString.of(description, _description),
        textEquivalent = R4bString.of(textEquivalent, _textEquivalent),
        priority =
          Enumeration.of(
            if (priority != null) RequestGroup.RequestPriority.fromCode(priority) else null,
            _priority,
          ),
        code = code ?: listOf(),
        documentation = documentation ?: listOf(),
        condition = condition ?: listOf(),
        relatedAction = relatedAction ?: listOf(),
        timing =
          RequestGroup.Action.Timing.from(
            DateTime.of(
              if (timingDateTime != null) FhirDateTime.fromString(timingDateTime) else null,
              _timingDateTime,
            ),
            timingAge,
            timingPeriod,
            timingDuration,
            timingRange,
            timingTiming,
          ),
        participant = participant ?: listOf(),
        type = type,
        groupingBehavior =
          Enumeration.of(
            if (groupingBehavior != null)
              RequestGroup.ActionGroupingBehavior.fromCode(groupingBehavior)
            else null,
            _groupingBehavior,
          ),
        selectionBehavior =
          Enumeration.of(
            if (selectionBehavior != null)
              RequestGroup.ActionSelectionBehavior.fromCode(selectionBehavior)
            else null,
            _selectionBehavior,
          ),
        requiredBehavior =
          Enumeration.of(
            if (requiredBehavior != null)
              RequestGroup.ActionRequiredBehavior.fromCode(requiredBehavior)
            else null,
            _requiredBehavior,
          ),
        precheckBehavior =
          Enumeration.of(
            if (precheckBehavior != null)
              RequestGroup.ActionPrecheckBehavior.fromCode(precheckBehavior)
            else null,
            _precheckBehavior,
          ),
        cardinalityBehavior =
          Enumeration.of(
            if (cardinalityBehavior != null)
              RequestGroup.ActionCardinalityBehavior.fromCode(cardinalityBehavior)
            else null,
            _cardinalityBehavior,
          ),
        resource = resource,
        action = action ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.prefix?.value)
      encodeElementIfNotNull(descriptor, 4, value.prefix)
      encodeStringIfNotNull(descriptor, 5, value.title?.value)
      encodeElementIfNotNull(descriptor, 6, value.title)
      encodeStringIfNotNull(descriptor, 7, value.description?.value)
      encodeElementIfNotNull(descriptor, 8, value.description)
      encodeStringIfNotNull(descriptor, 9, value.textEquivalent?.value)
      encodeElementIfNotNull(descriptor, 10, value.textEquivalent)
      encodeStringIfNotNull(descriptor, 11, value.priority?.value?.code)
      encodeElementIfNotNull(descriptor, 12, value.priority)
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      if (value.documentation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          RelatedArtifactSerializer.listSerializer,
          value.documentation,
        )
      if (value.condition.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          RequestGroupActionConditionSerializer.listSerializer,
          value.condition,
        )
      if (value.relatedAction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          RequestGroupActionRelatedActionSerializer.listSerializer,
          value.relatedAction,
        )
      when (val choice = value.timing) {
        null -> {}
        is RequestGroup.Action.Timing.DateTime -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is RequestGroup.Action.Timing.Age -> {
          encodeSerializableElement(descriptor, 19, AgeSerializer, choice.value)
        }
        is RequestGroup.Action.Timing.Period -> {
          encodeSerializableElement(descriptor, 20, PeriodSerializer, choice.value)
        }
        is RequestGroup.Action.Timing.Duration -> {
          encodeSerializableElement(descriptor, 21, DurationSerializer, choice.value)
        }
        is RequestGroup.Action.Timing.Range -> {
          encodeSerializableElement(descriptor, 22, RangeSerializer, choice.value)
        }
        is RequestGroup.Action.Timing.Timing -> {
          encodeSerializableElement(descriptor, 23, TimingSerializer, choice.value)
        }
      }
      if (value.participant.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          24,
          ReferenceSerializer.listSerializer,
          value.participant,
        )
      encodeSerializableIfNotNull(descriptor, 25, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 26, value.groupingBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 27, value.groupingBehavior)
      encodeStringIfNotNull(descriptor, 28, value.selectionBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 29, value.selectionBehavior)
      encodeStringIfNotNull(descriptor, 30, value.requiredBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 31, value.requiredBehavior)
      encodeStringIfNotNull(descriptor, 32, value.precheckBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 33, value.precheckBehavior)
      encodeStringIfNotNull(descriptor, 34, value.cardinalityBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 35, value.cardinalityBehavior)
      encodeSerializableIfNotNull(descriptor, 36, ReferenceSerializer, value.resource)
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          37,
          RequestGroupActionSerializer.listSerializer,
          value.action,
        )
    }
  }
}

internal object RequestGroupActionConditionSerializer : KSerializer<RequestGroup.Action.Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("kind", KotlinString.serializer().descriptor)
      optionalElement("_kind", ElementSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RequestGroup.Action.Condition>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestGroup.Action.Condition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var kind: KotlinString? = null
      var _kind: Element? = null
      var expression: Expression? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> kind = decodeStringElement(descriptor, i)
          4 -> _kind = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Condition: " + i)
        }
      }
      RequestGroup.Action.Condition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        kind =
          Enumeration.of(
            if (kind != null) RequestGroup.ActionConditionKind.fromCode(kind) else null,
            _kind,
          )
            ?: throw SerializationException(
              "Missing required property 'kind' on RequestGroup.Action.Condition"
            ),
        expression = expression,
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.Condition) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.kind.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.kind)
      encodeSerializableIfNotNull(descriptor, 5, ExpressionSerializer, value.expression)
    }
  }
}

internal object RequestGroupActionRelatedActionSerializer :
  KSerializer<RequestGroup.Action.RelatedAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedAction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("actionId", KotlinString.serializer().descriptor)
      optionalElement("_actionId", ElementSerializer.descriptor)
      optionalElement("relationship", KotlinString.serializer().descriptor)
      optionalElement("_relationship", ElementSerializer.descriptor)
      optionalElement("offsetDuration", DurationSerializer.descriptor)
      optionalElement("offsetRange", RangeSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RequestGroup.Action.RelatedAction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): RequestGroup.Action.RelatedAction =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> actionId = decodeStringElement(descriptor, i)
          4 -> _actionId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> relationship = decodeStringElement(descriptor, i)
          6 ->
            _relationship =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            offsetDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          8 -> offsetRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatedAction: " + i)
        }
      }
      RequestGroup.Action.RelatedAction(
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
            if (relationship != null) RequestGroup.ActionRelationshipType.fromCode(relationship)
            else null,
            _relationship,
          )
            ?: throw SerializationException(
              "Missing required property 'relationship' on RequestGroup.Action.RelatedAction"
            ),
        offset = RequestGroup.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.actionId.value)
      encodeElementIfNotNull(descriptor, 4, value.actionId)
      encodeStringIfNotNull(descriptor, 5, value.relationship.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.relationship)
      when (val choice = value.offset) {
        null -> {}
        is RequestGroup.Action.RelatedAction.Offset.Duration -> {
          encodeSerializableElement(descriptor, 7, DurationSerializer, choice.value)
        }
        is RequestGroup.Action.RelatedAction.Offset.Range -> {
          encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
        }
      }
    }
  }
}

internal object RequestGroupSerializer : FhirResourceSerializer<RequestGroup> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("RequestGroup")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("authoredOn", KotlinString.serializer().descriptor)
    b.optionalElement("_authoredOn", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("action", RequestGroupActionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> priority = decoder.decodeStringElement(descriptor, i)
        23 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 -> authoredOn = decoder.decodeStringElement(descriptor, i)
        28 ->
          _authoredOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        33 ->
          action =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RequestGroupActionSerializer.listSerializer,
              null,
            )
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
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on RequestGroup has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on RequestGroup has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(
          if (status != null) RequestGroup.RequestStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on RequestGroup"),
      intent =
        Enumeration.of(
          if (intent != null) RequestGroup.RequestIntent.fromCode(intent) else null,
          _intent,
        ) ?: throw SerializationException("Missing required property 'intent' on RequestGroup"),
      priority =
        Enumeration.of(
          if (priority != null) RequestGroup.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      code = code,
      subject = subject,
      encounter = encounter,
      authoredOn =
        DateTime.of(
          if (authoredOn != null) FhirDateTime.fromString(authoredOn) else null,
          _authoredOn,
        ),
      author = author,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      action = action ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RequestGroup,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.intent)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.priority)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.authoredOn?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.authoredOn)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        RequestGroupActionSerializer.listSerializer,
        value.action,
      )
  }
}
