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

import dev.ohs.fhir.model.r5.AdverseEvent
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String
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

internal object AdverseEventParticipantSerializer : KSerializer<AdverseEvent.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.Participant {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return AdverseEvent.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object AdverseEventSuspectEntitySerializer : KSerializer<AdverseEvent.SuspectEntity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SuspectEntity") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("instanceCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("instanceReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "causality",
        lazyDescriptor { AdverseEvent.SuspectEntity.Causality.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.SuspectEntity {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instanceCodeableConcept: CodeableConcept? = null
    var instanceReference: Reference? = null
    var causality: AdverseEvent.SuspectEntity.Causality? = null
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
          instanceCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.instanceCodeableConceptSer,
              null,
            )
        4 ->
          instanceReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.instanceReferenceSer, null)
        5 ->
          causality =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.causalitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SuspectEntity: " + __i)
      }
    }
    return AdverseEvent.SuspectEntity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      instance =
        AdverseEvent.SuspectEntity.Instance.from(instanceCodeableConcept, instanceReference)!!,
      causality = causality,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.SuspectEntity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.instance) {
      null -> {}
      is AdverseEvent.SuspectEntity.Instance.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.instanceCodeableConceptSer, __d.value)
      }
      is AdverseEvent.SuspectEntity.Instance.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.instanceReferenceSer, __d.value)
      }
    }
    (value.causality)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.causalitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val instanceCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val instanceReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val causalitySer: KSerializer<AdverseEvent.SuspectEntity.Causality> =
      AdverseEvent.SuspectEntity.Causality.serializer()
  }
}

internal object AdverseEventSuspectEntityCausalitySerializer :
  KSerializer<AdverseEvent.SuspectEntity.Causality> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Causality") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("assessmentMethod", CodeableConcept.serializer().descriptor, isOptional = true)
      element("entityRelatedness", CodeableConcept.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.SuspectEntity.Causality {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var assessmentMethod: CodeableConcept? = null
    var entityRelatedness: CodeableConcept? = null
    var author: Reference? = null
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
          assessmentMethod =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.assessmentMethodSer, null)
        4 ->
          entityRelatedness =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.assessmentMethodSer, null)
        5 -> author = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.authorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Causality: " + __i)
      }
    }
    return AdverseEvent.SuspectEntity.Causality(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      assessmentMethod = assessmentMethod,
      entityRelatedness = entityRelatedness,
      author = author,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: AdverseEvent.SuspectEntity.Causality,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.assessmentMethod)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.assessmentMethodSer, it)
    }
    (value.entityRelatedness)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.assessmentMethodSer, it)
    }
    (value.author)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.authorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val assessmentMethodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val authorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object AdverseEventContributingFactorSerializer :
  KSerializer<AdverseEvent.ContributingFactor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContributingFactor") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.ContributingFactor =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.ContributingFactor) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.ContributingFactor {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContributingFactor: " + __i)
      }
    }
    return AdverseEvent.ContributingFactor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.ContributingFactor.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.ContributingFactor) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is AdverseEvent.ContributingFactor.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemReferenceSer, __d.value)
      }
      is AdverseEvent.ContributingFactor.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemCodeableConceptSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object AdverseEventPreventiveActionSerializer :
  KSerializer<AdverseEvent.PreventiveAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PreventiveAction") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.PreventiveAction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.PreventiveAction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.PreventiveAction {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PreventiveAction: " + __i)
      }
    }
    return AdverseEvent.PreventiveAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.PreventiveAction.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.PreventiveAction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is AdverseEvent.PreventiveAction.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemReferenceSer, __d.value)
      }
      is AdverseEvent.PreventiveAction.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemCodeableConceptSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object AdverseEventMitigatingActionSerializer :
  KSerializer<AdverseEvent.MitigatingAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MitigatingAction") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.MitigatingAction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.MitigatingAction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.MitigatingAction {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MitigatingAction: " + __i)
      }
    }
    return AdverseEvent.MitigatingAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.MitigatingAction.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.MitigatingAction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is AdverseEvent.MitigatingAction.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemReferenceSer, __d.value)
      }
      is AdverseEvent.MitigatingAction.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemCodeableConceptSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object AdverseEventSupportingInfoSerializer : KSerializer<AdverseEvent.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.SupportingInfo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SupportingInfo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.SupportingInfo {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + __i)
      }
    }
    return AdverseEvent.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.SupportingInfo.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.SupportingInfo) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is AdverseEvent.SupportingInfo.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemReferenceSer, __d.value)
      }
      is AdverseEvent.SupportingInfo.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemCodeableConceptSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object AdverseEventSerializer : KSerializer<AdverseEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdverseEvent") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("actuality", String.serializer().descriptor, isOptional = true)
    b.element("_actuality", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("detected", String.serializer().descriptor, isOptional = true)
    b.element("_detected", Element.serializer().descriptor, isOptional = true)
    b.element("recordedDate", String.serializer().descriptor, isOptional = true)
    b.element("_recordedDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "resultingEffect",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("seriousness", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "outcome",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("recorder", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(lazyDescriptor { AdverseEvent.Participant.serializer().descriptor }),
      isOptional = true,
    )
    b.element("study", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("expectedInResearchStudy", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_expectedInResearchStudy", Element.serializer().descriptor, isOptional = true)
    b.element(
      "suspectEntity",
      listSerialDescriptor(lazyDescriptor { AdverseEvent.SuspectEntity.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "contributingFactor",
      listSerialDescriptor(
        lazyDescriptor { AdverseEvent.ContributingFactor.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "preventiveAction",
      listSerialDescriptor(
        lazyDescriptor { AdverseEvent.PreventiveAction.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "mitigatingAction",
      listSerialDescriptor(
        lazyDescriptor { AdverseEvent.MitigatingAction.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(lazyDescriptor { AdverseEvent.SupportingInfo.serializer().descriptor }),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AdverseEvent")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): AdverseEvent {
    val __desc = descriptor
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: String? = null
    var _status: Element? = null
    var actuality: String? = null
    var _actuality: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var detected: String? = null
    var _detected: Element? = null
    var recordedDate: String? = null
    var _recordedDate: Element? = null
    var resultingEffect: List<Reference>? = null
    var location: Reference? = null
    var seriousness: CodeableConcept? = null
    var outcome: List<CodeableConcept>? = null
    var recorder: Reference? = null
    var participant: List<AdverseEvent.Participant>? = null
    var study: List<Reference>? = null
    var expectedInResearchStudy: KotlinBoolean? = null
    var _expectedInResearchStudy: Element? = null
    var suspectEntity: List<AdverseEvent.SuspectEntity>? = null
    var contributingFactor: List<AdverseEvent.ContributingFactor>? = null
    var preventiveAction: List<AdverseEvent.PreventiveAction>? = null
    var mitigatingAction: List<AdverseEvent.MitigatingAction>? = null
    var supportingInfo: List<AdverseEvent.SupportingInfo>? = null
    var note: List<Annotation>? = null
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> actuality = decoder.decodeStringElement(__desc, 14)
        15 ->
          _actuality =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.categorySer, null)
        17 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.categorySerInner, null)
        18 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.subjectSer, null)
        20 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 20)
        21 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.occurrencePeriodSer, null)
        23 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.occurrenceTimingSer, null)
        24 -> detected = decoder.decodeStringElement(__desc, 24)
        25 ->
          _detected =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> recordedDate = decoder.decodeStringElement(__desc, 26)
        27 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          resultingEffect =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.resultingEffectSer, null)
        29 ->
          location = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.subjectSer, null)
        30 ->
          seriousness =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.categorySerInner, null)
        31 ->
          outcome = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.categorySer, null)
        32 ->
          recorder = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.subjectSer, null)
        33 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.participantSer, null)
        34 ->
          study =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.resultingEffectSer, null)
        35 -> expectedInResearchStudy = decoder.decodeBooleanElement(__desc, 35)
        36 ->
          _expectedInResearchStudy =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.suspectEntitySer, null)
        38 ->
          contributingFactor =
            decoder.decodeNullableSerializableElement(
              __desc,
              38,
              Hoisted.contributingFactorSer,
              null,
            )
        39 ->
          preventiveAction =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.preventiveActionSer, null)
        40 ->
          mitigatingAction =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.mitigatingActionSer, null)
        41 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.supportingInfoSer, null)
        42 -> note = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AdverseEvent: " + __i)
      }
    }
    return AdverseEvent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(AdverseEvent.AdverseEventStatus.fromCode(status!!), _status),
      actuality =
        Enumeration.of(AdverseEvent.AdverseEventActuality.fromCode(actuality!!), _actuality),
      category = category ?: listOf(),
      code = code,
      subject = subject!!,
      encounter = encounter,
      occurrence =
        AdverseEvent.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      detected = DateTime.of(FhirDateTime.fromString(detected), _detected),
      recordedDate = DateTime.of(FhirDateTime.fromString(recordedDate), _recordedDate),
      resultingEffect = resultingEffect ?: listOf(),
      location = location,
      seriousness = seriousness,
      outcome = outcome ?: listOf(),
      recorder = recorder,
      participant = participant ?: listOf(),
      study = study ?: listOf(),
      expectedInResearchStudy = R5Boolean.of(expectedInResearchStudy, _expectedInResearchStudy),
      suspectEntity = suspectEntity ?: listOf(),
      contributingFactor = contributingFactor ?: listOf(),
      preventiveAction = preventiveAction ?: listOf(),
      mitigatingAction = mitigatingAction ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent) {
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.actuality.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.actuality.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.categorySer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.subjectSer, it) }
    when (val __d = value.occurrence) {
      null -> {}
      is AdverseEvent.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
        }
      }
      is AdverseEvent.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.occurrencePeriodSer, __d.value)
      }
      is AdverseEvent.Occurrence.Timing -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.occurrenceTimingSer, __d.value)
      }
    }
    ((value.detected?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.detected?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.recordedDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    if (value.resultingEffect.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        28,
        Hoisted.resultingEffectSer,
        value.resultingEffect,
      )
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.subjectSer, it) }
    (value.seriousness)?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.categorySerInner, it)
    }
    if (value.outcome.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.categorySer, value.outcome)
    (value.recorder)?.let { encoder.encodeSerializableElement(__desc, 32, Hoisted.subjectSer, it) }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.participantSer, value.participant)
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.resultingEffectSer, value.study)
    ((value.expectedInResearchStudy?.value))?.let { encoder.encodeBooleanElement(__desc, 35, it) }
    (value.expectedInResearchStudy?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.suspectEntitySer, value.suspectEntity)
    if (value.contributingFactor.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        38,
        Hoisted.contributingFactorSer,
        value.contributingFactor,
      )
    if (value.preventiveAction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        39,
        Hoisted.preventiveActionSer,
        value.preventiveAction,
      )
    if (value.mitigatingAction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        40,
        Hoisted.mitigatingActionSer,
        value.mitigatingAction,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.supportingInfoSer, value.supportingInfo)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.noteSer, value.note)
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val resultingEffectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val participantSerInner: KSerializer<AdverseEvent.Participant> =
      AdverseEvent.Participant.serializer()

    public val participantSer: KSerializer<List<AdverseEvent.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val suspectEntitySerInner: KSerializer<AdverseEvent.SuspectEntity> =
      AdverseEvent.SuspectEntity.serializer()

    public val suspectEntitySer: KSerializer<List<AdverseEvent.SuspectEntity>> =
      ListSerializer(Hoisted.suspectEntitySerInner)

    public val contributingFactorSerInner: KSerializer<AdverseEvent.ContributingFactor> =
      AdverseEvent.ContributingFactor.serializer()

    public val contributingFactorSer: KSerializer<List<AdverseEvent.ContributingFactor>> =
      ListSerializer(Hoisted.contributingFactorSerInner)

    public val preventiveActionSerInner: KSerializer<AdverseEvent.PreventiveAction> =
      AdverseEvent.PreventiveAction.serializer()

    public val preventiveActionSer: KSerializer<List<AdverseEvent.PreventiveAction>> =
      ListSerializer(Hoisted.preventiveActionSerInner)

    public val mitigatingActionSerInner: KSerializer<AdverseEvent.MitigatingAction> =
      AdverseEvent.MitigatingAction.serializer()

    public val mitigatingActionSer: KSerializer<List<AdverseEvent.MitigatingAction>> =
      ListSerializer(Hoisted.mitigatingActionSerInner)

    public val supportingInfoSerInner: KSerializer<AdverseEvent.SupportingInfo> =
      AdverseEvent.SupportingInfo.serializer()

    public val supportingInfoSer: KSerializer<List<AdverseEvent.SupportingInfo>> =
      ListSerializer(Hoisted.supportingInfoSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object AdverseEventPolymorphicSerializer : KSerializer<AdverseEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdverseEvent") { AdverseEventSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    encoder.encodeStructure(descriptor) { AdverseEventSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    decoder.decodeStructure(descriptor) { AdverseEventSerializer.deserializeJson(this) }
}
