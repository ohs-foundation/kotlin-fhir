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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.SubscriptionTopic
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

internal object SubscriptionTopicResourceTriggerSerializer :
  KSerializer<SubscriptionTopic.ResourceTrigger> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResourceTrigger") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
      optionalElement("supportedInteraction", stringNullableListSerializer.descriptor)
      optionalElement("_supportedInteraction", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "queryCriteria",
        SubscriptionTopicResourceTriggerQueryCriteriaSerializer.descriptor,
      )
      optionalElement("fhirPathCriteria", KotlinString.serializer().descriptor)
      optionalElement("_fhirPathCriteria", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubscriptionTopic.ResourceTrigger>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubscriptionTopic.ResourceTrigger =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var resource: KotlinString? = null
      var _resource: Element? = null
      var supportedInteraction: List<KotlinString?>? = null
      var _supportedInteraction: List<Element?>? = null
      var queryCriteria: SubscriptionTopic.ResourceTrigger.QueryCriteria? = null
      var fhirPathCriteria: KotlinString? = null
      var _fhirPathCriteria: Element? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> resource = decodeStringElement(descriptor, i)
          6 -> _resource = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            supportedInteraction =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _supportedInteraction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 ->
            queryCriteria =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubscriptionTopicResourceTriggerQueryCriteriaSerializer,
                null,
              )
          10 -> fhirPathCriteria = decodeStringElement(descriptor, i)
          11 ->
            _fhirPathCriteria =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ResourceTrigger: " + i)
        }
      }
      SubscriptionTopic.ResourceTrigger(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = Markdown.of(description, _description),
        resource =
          Uri.of(resource, _resource)
            ?: throw SerializationException(
              "Missing required property 'resource' on SubscriptionTopic.ResourceTrigger"
            ),
        supportedInteraction =
          (kotlin.collections.List(
            maxOf(supportedInteraction?.size ?: 0, _supportedInteraction?.size ?: 0)
          ) { index ->
            Enumeration.of(
              supportedInteraction?.getOrNull(index)?.let {
                SubscriptionTopic.InteractionTrigger.fromCode(it)
              },
              _supportedInteraction?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'supportedInteraction' on SubscriptionTopic.ResourceTrigger has neither a value nor an id/extension"
              )
          }),
        queryCriteria = queryCriteria,
        fhirPathCriteria = R4bString.of(fhirPathCriteria, _fhirPathCriteria),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.ResourceTrigger) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeStringIfNotNull(descriptor, 5, value.resource.value)
      encodeElementIfNotNull(descriptor, 6, value.resource)
      if (value.supportedInteraction.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.supportedInteraction.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 8, value.supportedInteraction)
      }
      encodeSerializableIfNotNull(
        descriptor,
        9,
        SubscriptionTopicResourceTriggerQueryCriteriaSerializer,
        value.queryCriteria,
      )
      encodeStringIfNotNull(descriptor, 10, value.fhirPathCriteria?.value)
      encodeElementIfNotNull(descriptor, 11, value.fhirPathCriteria)
    }
  }
}

internal object SubscriptionTopicResourceTriggerQueryCriteriaSerializer :
  KSerializer<SubscriptionTopic.ResourceTrigger.QueryCriteria> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QueryCriteria") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("previous", KotlinString.serializer().descriptor)
      optionalElement("_previous", ElementSerializer.descriptor)
      optionalElement("resultForCreate", KotlinString.serializer().descriptor)
      optionalElement("_resultForCreate", ElementSerializer.descriptor)
      optionalElement("current", KotlinString.serializer().descriptor)
      optionalElement("_current", ElementSerializer.descriptor)
      optionalElement("resultForDelete", KotlinString.serializer().descriptor)
      optionalElement("_resultForDelete", ElementSerializer.descriptor)
      optionalElement("requireBoth", KotlinBoolean.serializer().descriptor)
      optionalElement("_requireBoth", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubscriptionTopic.ResourceTrigger.QueryCriteria>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubscriptionTopic.ResourceTrigger.QueryCriteria =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var previous: KotlinString? = null
      var _previous: Element? = null
      var resultForCreate: KotlinString? = null
      var _resultForCreate: Element? = null
      var current: KotlinString? = null
      var _current: Element? = null
      var resultForDelete: KotlinString? = null
      var _resultForDelete: Element? = null
      var requireBoth: KotlinBoolean? = null
      var _requireBoth: Element? = null
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
          3 -> previous = decodeStringElement(descriptor, i)
          4 -> _previous = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> resultForCreate = decodeStringElement(descriptor, i)
          6 ->
            _resultForCreate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> current = decodeStringElement(descriptor, i)
          8 -> _current = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> resultForDelete = decodeStringElement(descriptor, i)
          10 ->
            _resultForDelete =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> requireBoth = decodeBooleanElement(descriptor, i)
          12 ->
            _requireBoth = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding QueryCriteria: " + i)
        }
      }
      SubscriptionTopic.ResourceTrigger.QueryCriteria(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        previous = R4bString.of(previous, _previous),
        resultForCreate =
          Enumeration.of(
            if (resultForCreate != null)
              SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(resultForCreate)
            else null,
            _resultForCreate,
          ),
        current = R4bString.of(current, _current),
        resultForDelete =
          Enumeration.of(
            if (resultForDelete != null)
              SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(resultForDelete)
            else null,
            _resultForDelete,
          ),
        requireBoth = R4bBoolean.of(requireBoth, _requireBoth),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SubscriptionTopic.ResourceTrigger.QueryCriteria,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.previous?.value)
      encodeElementIfNotNull(descriptor, 4, value.previous)
      encodeStringIfNotNull(descriptor, 5, value.resultForCreate?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.resultForCreate)
      encodeStringIfNotNull(descriptor, 7, value.current?.value)
      encodeElementIfNotNull(descriptor, 8, value.current)
      encodeStringIfNotNull(descriptor, 9, value.resultForDelete?.value?.code)
      encodeElementIfNotNull(descriptor, 10, value.resultForDelete)
      encodeBooleanIfNotNull(descriptor, 11, value.requireBoth?.value)
      encodeElementIfNotNull(descriptor, 12, value.requireBoth)
    }
  }
}

internal object SubscriptionTopicEventTriggerSerializer :
  KSerializer<SubscriptionTopic.EventTrigger> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EventTrigger") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("event", CodeableConceptSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubscriptionTopic.EventTrigger>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubscriptionTopic.EventTrigger =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var event: CodeableConcept? = null
      var resource: KotlinString? = null
      var _resource: Element? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            event =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> resource = decodeStringElement(descriptor, i)
          7 -> _resource = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding EventTrigger: " + i)
        }
      }
      SubscriptionTopic.EventTrigger(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = Markdown.of(description, _description),
        event =
          event
            ?: throw SerializationException(
              "Missing required property 'event' on SubscriptionTopic.EventTrigger"
            ),
        resource =
          Uri.of(resource, _resource)
            ?: throw SerializationException(
              "Missing required property 'resource' on SubscriptionTopic.EventTrigger"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.EventTrigger) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.event)
      encodeStringIfNotNull(descriptor, 6, value.resource.value)
      encodeElementIfNotNull(descriptor, 7, value.resource)
    }
  }
}

internal object SubscriptionTopicCanFilterBySerializer :
  KSerializer<SubscriptionTopic.CanFilterBy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CanFilterBy") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
      optionalElement("filterParameter", KotlinString.serializer().descriptor)
      optionalElement("_filterParameter", ElementSerializer.descriptor)
      optionalElement("filterDefinition", KotlinString.serializer().descriptor)
      optionalElement("_filterDefinition", ElementSerializer.descriptor)
      optionalElement("modifier", stringNullableListSerializer.descriptor)
      optionalElement("_modifier", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubscriptionTopic.CanFilterBy>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubscriptionTopic.CanFilterBy =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var resource: KotlinString? = null
      var _resource: Element? = null
      var filterParameter: KotlinString? = null
      var _filterParameter: Element? = null
      var filterDefinition: KotlinString? = null
      var _filterDefinition: Element? = null
      var modifier: List<KotlinString?>? = null
      var _modifier: List<Element?>? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> resource = decodeStringElement(descriptor, i)
          6 -> _resource = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> filterParameter = decodeStringElement(descriptor, i)
          8 ->
            _filterParameter =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> filterDefinition = decodeStringElement(descriptor, i)
          10 ->
            _filterDefinition =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            modifier =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          12 ->
            _modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CanFilterBy: " + i)
        }
      }
      SubscriptionTopic.CanFilterBy(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = Markdown.of(description, _description),
        resource = Uri.of(resource, _resource),
        filterParameter =
          R4bString.of(filterParameter, _filterParameter)
            ?: throw SerializationException(
              "Missing required property 'filterParameter' on SubscriptionTopic.CanFilterBy"
            ),
        filterDefinition = Uri.of(filterDefinition, _filterDefinition),
        modifier =
          (kotlin.collections.List(maxOf(modifier?.size ?: 0, _modifier?.size ?: 0)) { index ->
            Enumeration.of(
              modifier?.getOrNull(index)?.let {
                SubscriptionTopic.SubscriptionSearchModifier.fromCode(it)
              },
              _modifier?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'modifier' on SubscriptionTopic.CanFilterBy has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.CanFilterBy) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeStringIfNotNull(descriptor, 5, value.resource?.value)
      encodeElementIfNotNull(descriptor, 6, value.resource)
      encodeStringIfNotNull(descriptor, 7, value.filterParameter.value)
      encodeElementIfNotNull(descriptor, 8, value.filterParameter)
      encodeStringIfNotNull(descriptor, 9, value.filterDefinition?.value)
      encodeElementIfNotNull(descriptor, 10, value.filterDefinition)
      if (value.modifier.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          11,
          stringNullableListSerializer,
          value.modifier.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 12, value.modifier)
      }
    }
  }
}

internal object SubscriptionTopicNotificationShapeSerializer :
  KSerializer<SubscriptionTopic.NotificationShape> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotificationShape") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
      optionalElement("include", stringNullableListSerializer.descriptor)
      optionalElement("_include", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("revInclude", stringNullableListSerializer.descriptor)
      optionalElement("_revInclude", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubscriptionTopic.NotificationShape>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubscriptionTopic.NotificationShape =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var resource: KotlinString? = null
      var _resource: Element? = null
      var include: List<KotlinString?>? = null
      var _include: List<Element?>? = null
      var revInclude: List<KotlinString?>? = null
      var _revInclude: List<Element?>? = null
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
          3 -> resource = decodeStringElement(descriptor, i)
          4 -> _resource = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            include =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _include =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 ->
            revInclude =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _revInclude =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding NotificationShape: " + i)
        }
      }
      SubscriptionTopic.NotificationShape(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        resource =
          Uri.of(resource, _resource)
            ?: throw SerializationException(
              "Missing required property 'resource' on SubscriptionTopic.NotificationShape"
            ),
        include =
          (kotlin.collections.List(maxOf(include?.size ?: 0, _include?.size ?: 0)) { index ->
            R4bString.of(include?.getOrNull(index), _include?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'include' on SubscriptionTopic.NotificationShape has neither a value nor an id/extension"
              )
          }),
        revInclude =
          (kotlin.collections.List(maxOf(revInclude?.size ?: 0, _revInclude?.size ?: 0)) { index ->
            R4bString.of(revInclude?.getOrNull(index), _revInclude?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'revInclude' on SubscriptionTopic.NotificationShape has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.NotificationShape) {
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
      encodeStringIfNotNull(descriptor, 3, value.resource.value)
      encodeElementIfNotNull(descriptor, 4, value.resource)
      if (value.include.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.include.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.include)
      }
      if (value.revInclude.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.revInclude.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.revInclude)
      }
    }
  }
}

internal object SubscriptionTopicSerializer : FhirResourceSerializer<SubscriptionTopic> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubscriptionTopic")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("derivedFrom", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFrom", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement(
      "resourceTrigger",
      SubscriptionTopicResourceTriggerSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "eventTrigger",
      SubscriptionTopicEventTriggerSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "canFilterBy",
      SubscriptionTopicCanFilterBySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "notificationShape",
      SubscriptionTopicNotificationShapeSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubscriptionTopic {
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
    var title: KotlinString? = null
    var _title: Element? = null
    var derivedFrom: List<KotlinString?>? = null
    var _derivedFrom: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
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
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var resourceTrigger: List<SubscriptionTopic.ResourceTrigger>? = null
    var eventTrigger: List<SubscriptionTopic.EventTrigger>? = null
    var canFilterBy: List<SubscriptionTopic.CanFilterBy>? = null
    var notificationShape: List<SubscriptionTopic.NotificationShape>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> title = decoder.decodeStringElement(descriptor, i)
        16 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        18 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        37 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        39 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        41 ->
          resourceTrigger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionTopicResourceTriggerSerializer.listSerializer,
              null,
            )
        42 ->
          eventTrigger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionTopicEventTriggerSerializer.listSerializer,
              null,
            )
        43 ->
          canFilterBy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionTopicCanFilterBySerializer.listSerializer,
              null,
            )
        44 ->
          notificationShape =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionTopicNotificationShapeSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubscriptionTopic: " + i)
      }
    }
    return SubscriptionTopic(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException("Missing required property 'url' on SubscriptionTopic"),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      title = R4bString.of(title, _title),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { index ->
          Canonical.of(derivedFrom?.getOrNull(index), _derivedFrom?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFrom' on SubscriptionTopic has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on SubscriptionTopic"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      resourceTrigger = resourceTrigger ?: listOf(),
      eventTrigger = eventTrigger ?: listOf(),
      canFilterBy = canFilterBy ?: listOf(),
      notificationShape = notificationShape ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubscriptionTopic,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.title)
    if (value.derivedFrom.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        17 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFrom.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 18 + descriptorOffset, value.derivedFrom)
    }
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 21 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.resourceTrigger.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        SubscriptionTopicResourceTriggerSerializer.listSerializer,
        value.resourceTrigger,
      )
    if (value.eventTrigger.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        SubscriptionTopicEventTriggerSerializer.listSerializer,
        value.eventTrigger,
      )
    if (value.canFilterBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        SubscriptionTopicCanFilterBySerializer.listSerializer,
        value.canFilterBy,
      )
    if (value.notificationShape.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        SubscriptionTopicNotificationShapeSerializer.listSerializer,
        value.notificationShape,
      )
  }
}
