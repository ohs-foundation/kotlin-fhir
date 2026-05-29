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

@file:OptIn(ExperimentalSerializationApi::class)

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
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.Participant) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.Participant {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.functionSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AdverseEvent.Participant) {
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
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.functionSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, value.actor)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.SuspectEntity {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instanceCodeableConcept: CodeableConcept? = null
    var instanceReference: Reference? = null
    var causality: AdverseEvent.SuspectEntity.Causality? = null
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
          instanceCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instanceCodeableConceptSer,
              null,
            )
        4 ->
          instanceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instanceReferenceSer,
              null,
            )
        5 ->
          causality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.causalitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SuspectEntity: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AdverseEvent.SuspectEntity) {
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
    when (val choice = value.instance) {
      is AdverseEvent.SuspectEntity.Instance.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.instanceCodeableConceptSer,
          choice.value,
        )
      }
      is AdverseEvent.SuspectEntity.Instance.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.instanceReferenceSer, choice.value)
      }
    }
    (value.causality)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.causalitySer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.SuspectEntity.Causality {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var assessmentMethod: CodeableConcept? = null
    var entityRelatedness: CodeableConcept? = null
    var author: Reference? = null
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
          assessmentMethod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.assessmentMethodSer,
              null,
            )
        4 ->
          entityRelatedness =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.assessmentMethodSer,
              null,
            )
        5 ->
          author = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Causality: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: AdverseEvent.SuspectEntity.Causality,
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
    (value.assessmentMethod)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.assessmentMethodSer, it)
    }
    (value.entityRelatedness)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.assessmentMethodSer, it)
    }
    (value.author)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.authorSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.ContributingFactor) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.ContributingFactor {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContributingFactor: " + i)
      }
    }
    return AdverseEvent.ContributingFactor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.ContributingFactor.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: AdverseEvent.ContributingFactor,
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
    when (val choice = value.item) {
      is AdverseEvent.ContributingFactor.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemReferenceSer, choice.value)
      }
      is AdverseEvent.ContributingFactor.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.PreventiveAction) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.PreventiveAction {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PreventiveAction: " + i)
      }
    }
    return AdverseEvent.PreventiveAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.PreventiveAction.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AdverseEvent.PreventiveAction) {
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
    when (val choice = value.item) {
      is AdverseEvent.PreventiveAction.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemReferenceSer, choice.value)
      }
      is AdverseEvent.PreventiveAction.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.MitigatingAction) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.MitigatingAction {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MitigatingAction: " + i)
      }
    }
    return AdverseEvent.MitigatingAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.MitigatingAction.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AdverseEvent.MitigatingAction) {
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
    when (val choice = value.item) {
      is AdverseEvent.MitigatingAction.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemReferenceSer, choice.value)
      }
      is AdverseEvent.MitigatingAction.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SupportingInfo) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.SupportingInfo {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
      }
    }
    return AdverseEvent.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = AdverseEvent.SupportingInfo.Item.from(itemReference, itemCodeableConcept)!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AdverseEvent.SupportingInfo) {
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
    when (val choice = value.item) {
      is AdverseEvent.SupportingInfo.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemReferenceSer, choice.value)
      }
      is AdverseEvent.SupportingInfo.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AdverseEvent")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AdverseEvent {
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> actuality = decoder.decodeStringElement(descriptor, i)
        14 ->
          _actuality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        16 ->
          code =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        19 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        22 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        23 -> detected = decoder.decodeStringElement(descriptor, i)
        24 ->
          _detected =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        26 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          resultingEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingEffectSer,
              null,
            )
        28 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        29 ->
          seriousness =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        30 ->
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        31 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        32 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        33 ->
          study =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingEffectSer,
              null,
            )
        34 -> expectedInResearchStudy = decoder.decodeBooleanElement(descriptor, i)
        35 ->
          _expectedInResearchStudy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.suspectEntitySer, null)
        37 ->
          contributingFactor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributingFactorSer,
              null,
            )
        38 ->
          preventiveAction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.preventiveActionSer,
              null,
            )
        39 ->
          mitigatingAction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.mitigatingActionSer,
              null,
            )
        40 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInfoSer,
              null,
            )
        41 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        else -> throw SerializationException("Unexpected index decoding AdverseEvent: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AdverseEvent,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.actuality.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.actuality.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      Hoisted.subjectSer,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.subjectSer, it)
    }
    when (val choice = value.occurrence) {
      null -> {}
      is AdverseEvent.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            20 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is AdverseEvent.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.occurrencePeriodSer,
          choice.value,
        )
      }
      is AdverseEvent.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          Hoisted.occurrenceTimingSer,
          choice.value,
        )
      }
    }
    ((value.detected?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.detected?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.recordedDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.resultingEffect.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.resultingEffectSer,
        value.resultingEffect,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.seriousness)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    if (value.outcome.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.categorySer,
        value.outcome,
      )
    (value.recorder)?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.resultingEffectSer,
        value.study,
      )
    ((value.expectedInResearchStudy?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.expectedInResearchStudy?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.suspectEntitySer,
        value.suspectEntity,
      )
    if (value.contributingFactor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.contributingFactorSer,
        value.contributingFactor,
      )
    if (value.preventiveAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.preventiveActionSer,
        value.preventiveAction,
      )
    if (value.mitigatingAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.mitigatingActionSer,
        value.mitigatingAction,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.supportingInfoSer,
        value.supportingInfo,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
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
    encoder.encodeStructure(descriptor) {
      AdverseEventSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    decoder.decodeStructure(descriptor) {
      AdverseEventSerializer.deserializeInternal(this, descriptor, 0)
    }
}
