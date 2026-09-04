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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Resource
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

internal object SubscriptionTopicResourceTriggerSerializer :
  KSerializer<SubscriptionTopic.ResourceTrigger> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResourceTrigger") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
      element(
        "supportedInteraction",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_supportedInteraction",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "queryCriteria",
        lazyDescriptor { SubscriptionTopic.ResourceTrigger.QueryCriteria.serializer().descriptor },
        isOptional = true,
      )
      element("fhirPathCriteria", KotlinString.serializer().descriptor, isOptional = true)
      element("_fhirPathCriteria", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.ResourceTrigger =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.ResourceTrigger) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubscriptionTopic.ResourceTrigger {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> resource = decoder.decodeStringElement(descriptor, i)
        6 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 ->
          supportedInteraction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedInteractionSer,
              null,
            )
        8 ->
          _supportedInteraction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportedInteractionSer2,
              null,
            )
        9 ->
          queryCriteria =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.queryCriteriaSer, null)
        10 -> fhirPathCriteria = decoder.decodeStringElement(descriptor, i)
        11 ->
          _fhirPathCriteria =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ResourceTrigger: " + i)
      }
    }
    return SubscriptionTopic.ResourceTrigger(
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
          )!!
        }),
      queryCriteria = queryCriteria,
      fhirPathCriteria = R4bString.of(fhirPathCriteria, _fhirPathCriteria),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubscriptionTopic.ResourceTrigger,
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    ((value.resource.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.resource.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    (value.supportedInteraction.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.supportedInteractionSer, it)
    }
    (value.supportedInteraction.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.supportedInteractionSer2, it)
    }
    (value.queryCriteria)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.queryCriteriaSer, it)
    }
    ((value.fhirPathCriteria?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.fhirPathCriteria?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val supportedInteractionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val supportedInteractionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.supportedInteractionSerInner).nullable)

    public val supportedInteractionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.descriptionSer).nullable)

    public val queryCriteriaSer: KSerializer<SubscriptionTopic.ResourceTrigger.QueryCriteria> =
      SubscriptionTopic.ResourceTrigger.QueryCriteria.serializer()
  }
}

internal object SubscriptionTopicResourceTriggerQueryCriteriaSerializer :
  KSerializer<SubscriptionTopic.ResourceTrigger.QueryCriteria> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QueryCriteria") {
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
      element("previous", KotlinString.serializer().descriptor, isOptional = true)
      element("_previous", Element.serializer().descriptor, isOptional = true)
      element("resultForCreate", KotlinString.serializer().descriptor, isOptional = true)
      element("_resultForCreate", Element.serializer().descriptor, isOptional = true)
      element("current", KotlinString.serializer().descriptor, isOptional = true)
      element("_current", Element.serializer().descriptor, isOptional = true)
      element("resultForDelete", KotlinString.serializer().descriptor, isOptional = true)
      element("_resultForDelete", Element.serializer().descriptor, isOptional = true)
      element("requireBoth", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_requireBoth", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.ResourceTrigger.QueryCriteria =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SubscriptionTopic.ResourceTrigger.QueryCriteria,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubscriptionTopic.ResourceTrigger.QueryCriteria {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> previous = decoder.decodeStringElement(descriptor, i)
        4 ->
          _previous =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.previousSer, null)
        5 -> resultForCreate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _resultForCreate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.previousSer, null)
        7 -> current = decoder.decodeStringElement(descriptor, i)
        8 ->
          _current =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.previousSer, null)
        9 -> resultForDelete = decoder.decodeStringElement(descriptor, i)
        10 ->
          _resultForDelete =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.previousSer, null)
        11 -> requireBoth = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _requireBoth =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.previousSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QueryCriteria: " + i)
      }
    }
    return SubscriptionTopic.ResourceTrigger.QueryCriteria(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      previous = R4bString.of(previous, _previous),
      resultForCreate =
        Enumeration.of(
          resultForCreate?.let { SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(it) },
          _resultForCreate,
        ),
      current = R4bString.of(current, _current),
      resultForDelete =
        Enumeration.of(
          resultForDelete?.let { SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(it) },
          _resultForDelete,
        ),
      requireBoth = R4bBoolean.of(requireBoth, _requireBoth),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubscriptionTopic.ResourceTrigger.QueryCriteria,
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
    ((value.previous?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.previous?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.previousSer, it)
    }
    ((value.resultForCreate?.value?.code))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.resultForCreate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.previousSer, it)
    }
    ((value.current?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.current?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.previousSer, it)
    }
    ((value.resultForDelete?.value?.code))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.resultForDelete?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.previousSer, it)
    }
    ((value.requireBoth?.value))?.let { encoder.encodeBooleanElement(descriptor, 11, it) }
    (value.requireBoth?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.previousSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val previousSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubscriptionTopicEventTriggerSerializer :
  KSerializer<SubscriptionTopic.EventTrigger> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EventTrigger") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("event", CodeableConcept.serializer().descriptor, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.EventTrigger =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.EventTrigger) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubscriptionTopic.EventTrigger {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var event: CodeableConcept? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 ->
          event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        6 -> resource = decoder.decodeStringElement(descriptor, i)
        7 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EventTrigger: " + i)
      }
    }
    return SubscriptionTopic.EventTrigger(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubscriptionTopic.EventTrigger,
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.eventSer, value.event)
    ((value.resource.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.resource.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val eventSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object SubscriptionTopicCanFilterBySerializer :
  KSerializer<SubscriptionTopic.CanFilterBy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CanFilterBy") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
      element("filterParameter", KotlinString.serializer().descriptor, isOptional = true)
      element("_filterParameter", Element.serializer().descriptor, isOptional = true)
      element("filterDefinition", KotlinString.serializer().descriptor, isOptional = true)
      element("_filterDefinition", Element.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_modifier", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.CanFilterBy =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.CanFilterBy) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubscriptionTopic.CanFilterBy {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> resource = decoder.decodeStringElement(descriptor, i)
        6 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 -> filterParameter = decoder.decodeStringElement(descriptor, i)
        8 ->
          _filterParameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        9 -> filterDefinition = decoder.decodeStringElement(descriptor, i)
        10 ->
          _filterDefinition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        11 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        12 ->
          _modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CanFilterBy: " + i)
      }
    }
    return SubscriptionTopic.CanFilterBy(
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
          )!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubscriptionTopic.CanFilterBy) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    ((value.resource?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    ((value.filterParameter.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.filterParameter.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.descriptionSer, it)
    }
    ((value.filterDefinition?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.filterDefinition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.descriptionSer, it)
    }
    (value.modifier.map { it.value?.code }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.modifierSer, it)
    }
    (value.modifier.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.modifierSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val modifierSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val modifierSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.modifierSerInner).nullable)

    public val modifierSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.descriptionSer).nullable)
  }
}

internal object SubscriptionTopicNotificationShapeSerializer :
  KSerializer<SubscriptionTopic.NotificationShape> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotificationShape") {
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
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
      element(
        "include",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_include", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "revInclude",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_revInclude",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.NotificationShape =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.NotificationShape) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubscriptionTopic.NotificationShape {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> resource = decoder.decodeStringElement(descriptor, i)
        4 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        5 ->
          include =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.includeSer, null)
        6 ->
          _include =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.includeSer2, null)
        7 ->
          revInclude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.includeSer, null)
        8 ->
          _revInclude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.includeSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotificationShape: " + i)
      }
    }
    return SubscriptionTopic.NotificationShape(
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
          R4bString.of(include?.getOrNull(index)?.let { it }, _include?.getOrNull(index))!!
        }),
      revInclude =
        (kotlin.collections.List(maxOf(revInclude?.size ?: 0, _revInclude?.size ?: 0)) { index ->
          R4bString.of(revInclude?.getOrNull(index)?.let { it }, _revInclude?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubscriptionTopic.NotificationShape,
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
    ((value.resource.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.resource.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resourceSer, it)
    }
    (value.include.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.includeSer, it)
    }
    (value.include.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.includeSer2, it)
    }
    (value.revInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.includeSer, it)
    }
    (value.revInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.includeSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resourceSer: KSerializer<Element> = Element.serializer()

    public val includeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val includeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.includeSerInner).nullable)

    public val includeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.resourceSer).nullable)
  }
}

internal object SubscriptionTopicSerializer : KSerializer<SubscriptionTopic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubscriptionTopic") {
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
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFrom",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFrom",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
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
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "resourceTrigger",
      listSerialDescriptor(
        lazyDescriptor { SubscriptionTopic.ResourceTrigger.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "eventTrigger",
      listSerialDescriptor(
        lazyDescriptor { SubscriptionTopic.EventTrigger.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "canFilterBy",
      listSerialDescriptor(
        lazyDescriptor { SubscriptionTopic.CanFilterBy.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "notificationShape",
      listSerialDescriptor(
        lazyDescriptor { SubscriptionTopic.NotificationShape.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubscriptionTopic")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        15 -> title = decoder.decodeStringElement(descriptor, i)
        16 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.derivedFromSer, null)
        18 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.derivedFromSer2, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        37 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        38 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        39 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        40 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        41 ->
          resourceTrigger =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resourceTriggerSer,
              null,
            )
        42 ->
          eventTrigger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventTriggerSer, null)
        43 ->
          canFilterBy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.canFilterBySer, null)
        44 ->
          notificationShape =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.notificationShapeSer,
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
          Canonical.of(derivedFrom?.getOrNull(index)?.let { it }, _derivedFrom?.getOrNull(index))!!
        }),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on SubscriptionTopic"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(approvalDate?.let { FhirDate.fromString(it) }, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate?.let { FhirDate.fromString(it) }, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      resourceTrigger = resourceTrigger ?: listOf(),
      eventTrigger = eventTrigger ?: listOf(),
      canFilterBy = canFilterBy ?: listOf(),
      notificationShape = notificationShape ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubscriptionTopic,
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
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url.toElement())?.let {
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
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.derivedFrom.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.derivedFromSer,
        it,
      )
    }
    (value.derivedFrom.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.derivedFromSer2,
        it,
      )
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 36 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.resourceTrigger.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.resourceTriggerSer,
        value.resourceTrigger,
      )
    if (value.eventTrigger.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.eventTriggerSer,
        value.eventTrigger,
      )
    if (value.canFilterBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.canFilterBySer,
        value.canFilterBy,
      )
    if (value.notificationShape.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.notificationShapeSer,
        value.notificationShape,
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

    public val derivedFromSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val derivedFromSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.derivedFromSerInner).nullable)

    public val derivedFromSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val resourceTriggerSerInner: KSerializer<SubscriptionTopic.ResourceTrigger> =
      SubscriptionTopic.ResourceTrigger.serializer()

    public val resourceTriggerSer: KSerializer<List<SubscriptionTopic.ResourceTrigger>> =
      ListSerializer(Hoisted.resourceTriggerSerInner)

    public val eventTriggerSerInner: KSerializer<SubscriptionTopic.EventTrigger> =
      SubscriptionTopic.EventTrigger.serializer()

    public val eventTriggerSer: KSerializer<List<SubscriptionTopic.EventTrigger>> =
      ListSerializer(Hoisted.eventTriggerSerInner)

    public val canFilterBySerInner: KSerializer<SubscriptionTopic.CanFilterBy> =
      SubscriptionTopic.CanFilterBy.serializer()

    public val canFilterBySer: KSerializer<List<SubscriptionTopic.CanFilterBy>> =
      ListSerializer(Hoisted.canFilterBySerInner)

    public val notificationShapeSerInner: KSerializer<SubscriptionTopic.NotificationShape> =
      SubscriptionTopic.NotificationShape.serializer()

    public val notificationShapeSer: KSerializer<List<SubscriptionTopic.NotificationShape>> =
      ListSerializer(Hoisted.notificationShapeSerInner)
  }
}

internal object SubscriptionTopicPolymorphicSerializer : KSerializer<SubscriptionTopic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubscriptionTopic") {
      SubscriptionTopicSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic) {
    encoder.encodeStructure(descriptor) {
      SubscriptionTopicSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic =
    decoder.decodeStructure(descriptor) {
      SubscriptionTopicSerializer.deserializeInternal(this, descriptor, 0)
    }
}
