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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubscriptionTopic
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.ResourceTrigger) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubscriptionTopic.ResourceTrigger {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 -> resource = decoder.decodeStringElement(__desc, __i)
        6 ->
          _resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        7 ->
          supportedInteraction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.supportedInteractionSer,
              null,
            )
        8 ->
          _supportedInteraction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.supportedInteractionSer2,
              null,
            )
        9 ->
          queryCriteria =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.queryCriteriaSer, null)
        10 -> fhirPathCriteria = decoder.decodeStringElement(__desc, __i)
        11 ->
          _fhirPathCriteria =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ResourceTrigger: " + __i)
      }
    }
    return SubscriptionTopic.ResourceTrigger(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      resource = Uri.of(resource, _resource)!!,
      supportedInteraction =
        (kotlin.collections.List(
          maxOf(supportedInteraction?.size ?: 0, _supportedInteraction?.size ?: 0)
        ) { __i ->
          Enumeration.of(
            SubscriptionTopic.InteractionTrigger.fromCode(supportedInteraction?.getOrNull(__i)!!),
            _supportedInteraction?.getOrNull(__i),
          )
        }),
      queryCriteria = queryCriteria,
      fhirPathCriteria = R5String.of(fhirPathCriteria, _fhirPathCriteria),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubscriptionTopic.ResourceTrigger) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.resource.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.resource.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    (value.supportedInteraction.map { it.value?.getCode() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.supportedInteractionSer, it) }
    (value.supportedInteraction.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.supportedInteractionSer2, it)
    }
    (value.queryCriteria)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.queryCriteriaSer, it)
    }
    ((value.fhirPathCriteria?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.fhirPathCriteria?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.descriptionSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubscriptionTopic.ResourceTrigger.QueryCriteria,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubscriptionTopic.ResourceTrigger.QueryCriteria {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> previous = decoder.decodeStringElement(__desc, __i)
        4 ->
          _previous =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.previousSer, null)
        5 -> resultForCreate = decoder.decodeStringElement(__desc, __i)
        6 ->
          _resultForCreate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.previousSer, null)
        7 -> current = decoder.decodeStringElement(__desc, __i)
        8 ->
          _current =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.previousSer, null)
        9 -> resultForDelete = decoder.decodeStringElement(__desc, __i)
        10 ->
          _resultForDelete =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.previousSer, null)
        11 -> requireBoth = decoder.decodeBooleanElement(__desc, __i)
        12 ->
          _requireBoth =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.previousSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding QueryCriteria: " + __i)
      }
    }
    return SubscriptionTopic.ResourceTrigger.QueryCriteria(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      previous = R5String.of(previous, _previous),
      resultForCreate =
        resultForCreate?.let {
          Enumeration.of(SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(it), _resultForCreate)
        },
      current = R5String.of(current, _current),
      resultForDelete =
        resultForDelete?.let {
          Enumeration.of(SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(it), _resultForDelete)
        },
      requireBoth = R5Boolean.of(requireBoth, _requireBoth),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubscriptionTopic.ResourceTrigger.QueryCriteria,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.previous?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.previous?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.previousSer, it)
    }
    ((value.resultForCreate?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.resultForCreate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.previousSer, it)
    }
    ((value.current?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.current?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.previousSer, it)
    }
    ((value.resultForDelete?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.resultForDelete?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.previousSer, it)
    }
    ((value.requireBoth?.value))?.let { encoder.encodeBooleanElement(__desc, 11, it) }
    (value.requireBoth?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.previousSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.EventTrigger) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubscriptionTopic.EventTrigger {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var event: CodeableConcept? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 -> event = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventSer, null)
        6 -> resource = decoder.decodeStringElement(__desc, __i)
        7 ->
          _resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EventTrigger: " + __i)
      }
    }
    return SubscriptionTopic.EventTrigger(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      event = event!!,
      resource = Uri.of(resource, _resource)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubscriptionTopic.EventTrigger) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    (value.event)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.eventSer, it) }
    ((value.resource.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.resource.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.descriptionSer, it)
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
        "comparator",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_comparator",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifier",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_modifier", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.CanFilterBy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.CanFilterBy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubscriptionTopic.CanFilterBy {
    val __desc = descriptor
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
    var comparator: List<KotlinString?>? = null
    var _comparator: List<Element?>? = null
    var modifier: List<KotlinString?>? = null
    var _modifier: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 -> resource = decoder.decodeStringElement(__desc, __i)
        6 ->
          _resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        7 -> filterParameter = decoder.decodeStringElement(__desc, __i)
        8 ->
          _filterParameter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        9 -> filterDefinition = decoder.decodeStringElement(__desc, __i)
        10 ->
          _filterDefinition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        11 ->
          comparator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.comparatorSer, null)
        12 ->
          _comparator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.comparatorSer2, null)
        13 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.comparatorSer, null)
        14 ->
          _modifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.comparatorSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CanFilterBy: " + __i)
      }
    }
    return SubscriptionTopic.CanFilterBy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      resource = Uri.of(resource, _resource),
      filterParameter = R5String.of(filterParameter, _filterParameter)!!,
      filterDefinition = Uri.of(filterDefinition, _filterDefinition),
      comparator =
        (kotlin.collections.List(maxOf(comparator?.size ?: 0, _comparator?.size ?: 0)) { __i ->
          Enumeration.of(
            SubscriptionTopic.SearchComparator.fromCode(comparator?.getOrNull(__i)!!),
            _comparator?.getOrNull(__i),
          )
        }),
      modifier =
        (kotlin.collections.List(maxOf(modifier?.size ?: 0, _modifier?.size ?: 0)) { __i ->
          Enumeration.of(
            SubscriptionTopic.SearchModifierCode.fromCode(modifier?.getOrNull(__i)!!),
            _modifier?.getOrNull(__i),
          )
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubscriptionTopic.CanFilterBy) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.resource?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.filterParameter.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.filterParameter.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
    ((value.filterDefinition?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.filterDefinition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.descriptionSer, it)
    }
    (value.comparator.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.comparatorSer, it)
    }
    (value.comparator.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.comparatorSer2, it)
    }
    (value.modifier.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.comparatorSer, it)
    }
    (value.modifier.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.comparatorSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val comparatorSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val comparatorSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.comparatorSerInner).nullable)

    public val comparatorSer2: KSerializer<List<Element?>> =
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.NotificationShape) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubscriptionTopic.NotificationShape {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> resource = decoder.decodeStringElement(__desc, __i)
        4 ->
          _resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer, null)
        5 ->
          include = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.includeSer, null)
        6 ->
          _include =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.includeSer2, null)
        7 ->
          revInclude =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.includeSer, null)
        8 ->
          _revInclude =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.includeSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotificationShape: " + __i)
      }
    }
    return SubscriptionTopic.NotificationShape(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resource = Uri.of(resource, _resource)!!,
      include =
        (kotlin.collections.List(maxOf(include?.size ?: 0, _include?.size ?: 0)) { __i ->
          R5String.of(include?.getOrNull(__i)?.let { it }, _include?.getOrNull(__i))!!
        }),
      revInclude =
        (kotlin.collections.List(maxOf(revInclude?.size ?: 0, _revInclude?.size ?: 0)) { __i ->
          R5String.of(revInclude?.getOrNull(__i)?.let { it }, _revInclude?.getOrNull(__i))!!
        }),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubscriptionTopic.NotificationShape,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.resource.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.resource.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.resourceSer, it)
    }
    (value.include.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.includeSer, it)
    }
    (value.include.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.includeSer2, it)
    }
    (value.revInclude.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.includeSer, it)
    }
    (value.revInclude.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.includeSer2, it)
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
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
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
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubscriptionTopic")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): SubscriptionTopic {
    val __desc = desc
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(__desc, __i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(__desc, __i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(__desc, __i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer, null)
        23 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.derivedFromSer2, null)
        24 -> status = decoder.decodeStringElement(__desc, __i)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 -> date = decoder.decodeStringElement(__desc, __i)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(__desc, __i)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(__desc, __i)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        37 -> purpose = decoder.decodeStringElement(__desc, __i)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        39 -> copyright = decoder.decodeStringElement(__desc, __i)
        40 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        41 -> copyrightLabel = decoder.decodeStringElement(__desc, __i)
        42 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        43 -> approvalDate = decoder.decodeStringElement(__desc, __i)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(__desc, __i)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectivePeriodSer, null)
        48 ->
          resourceTrigger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceTriggerSer, null)
        49 ->
          eventTrigger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventTriggerSer, null)
        50 ->
          canFilterBy =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.canFilterBySer, null)
        51 ->
          notificationShape =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.notificationShapeSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubscriptionTopic: " + __i)
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
      url = Uri.of(url, _url)!!,
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        SubscriptionTopic.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { __i ->
          Canonical.of(derivedFrom?.getOrNull(__i)?.let { it }, _derivedFrom?.getOrNull(__i))!!
        }),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      resourceTrigger = resourceTrigger ?: listOf(),
      eventTrigger = eventTrigger ?: listOf(),
      canFilterBy = canFilterBy ?: listOf(),
      notificationShape = notificationShape ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: SubscriptionTopic,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is SubscriptionTopic.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is SubscriptionTopic.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          __desc,
          17 + __off,
          Hoisted.versionAlgorithmCodingSer,
          __d.value,
        )
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.derivedFrom.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.derivedFromSer, it)
    }
    (value.derivedFrom.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.derivedFromSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 26 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 30 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 33 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        36 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 37 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 39 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 41 + __off, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 43 + __off, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 45 + __off, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.effectivePeriodSer, it)
    }
    if (value.resourceTrigger.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        48 + __off,
        Hoisted.resourceTriggerSer,
        value.resourceTrigger,
      )
    if (value.eventTrigger.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        49 + __off,
        Hoisted.eventTriggerSer,
        value.eventTrigger,
      )
    if (value.canFilterBy.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        50 + __off,
        Hoisted.canFilterBySer,
        value.canFilterBy,
      )
    if (value.notificationShape.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        51 + __off,
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

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
      SubscriptionTopicSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic =
    decoder.decodeStructure(descriptor) {
      SubscriptionTopicSerializer.deserializeJson(this, descriptor, 0)
    }
}
