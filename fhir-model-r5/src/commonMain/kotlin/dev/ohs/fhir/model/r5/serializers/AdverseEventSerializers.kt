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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.AdverseEventActuality
import dev.ohs.fhir.model.r5.terminologies.AdverseEventStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object AdverseEventParticipantSerializer : FhirSerializer<AdverseEvent.Participant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Participant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.Participant>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.descriptor)
    b.optionalElement("actor", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.Participant {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.Participant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      function = function,
      actor = required(actor, "AdverseEvent.Participant", "actor"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.Participant) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.function,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventSuspectEntitySerializer : FhirSerializer<AdverseEvent.SuspectEntity> {
  override val descriptor: SerialDescriptor = buildDescriptor("SuspectEntity", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.SuspectEntity>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("instanceCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("instanceReference", ReferenceSerializer.descriptor)
    b.optionalElement("causality", AdverseEventSuspectEntityCausalitySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instanceCodeableConcept: CodeableConcept? = null
    var instanceReference: Reference? = null
    var causality: AdverseEvent.SuspectEntity.Causality? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          instanceCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          instanceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 ->
          causality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSuspectEntityCausalitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.SuspectEntity(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      instance =
        required(
          AdverseEvent.SuspectEntity.Instance.from(instanceCodeableConcept, instanceReference),
          "AdverseEvent.SuspectEntity",
          "instance",
        ),
      causality = causality,
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.instance) {
      is AdverseEvent.SuspectEntity.Instance.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is AdverseEvent.SuspectEntity.Instance.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      AdverseEventSuspectEntityCausalitySerializer,
      value.causality,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventSuspectEntityCausalitySerializer :
  FhirSerializer<AdverseEvent.SuspectEntity.Causality> {
  override val descriptor: SerialDescriptor = buildDescriptor("Causality", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.SuspectEntity.Causality>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("assessmentMethod", CodeableConceptSerializer.descriptor)
    b.optionalElement("entityRelatedness", CodeableConceptSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var assessmentMethod: CodeableConcept? = null
    var entityRelatedness: CodeableConcept? = null
    var author: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          assessmentMethod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          entityRelatedness =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.SuspectEntity.Causality(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      assessmentMethod = assessmentMethod,
      entityRelatedness = entityRelatedness,
      author = author,
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.assessmentMethod,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.entityRelatedness,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.author)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventContributingFactorSerializer :
  FhirSerializer<AdverseEvent.ContributingFactor> {
  override val descriptor: SerialDescriptor = buildDescriptor("ContributingFactor", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.ContributingFactor>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("itemReference", ReferenceSerializer.descriptor)
    b.optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.ContributingFactor {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.ContributingFactor(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item =
        required(
          AdverseEvent.ContributingFactor.Item.from(itemReference, itemCodeableConcept),
          "AdverseEvent.ContributingFactor",
          "item",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.ContributingFactor) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.item) {
      is AdverseEvent.ContributingFactor.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is AdverseEvent.ContributingFactor.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventPreventiveActionSerializer :
  FhirSerializer<AdverseEvent.PreventiveAction> {
  override val descriptor: SerialDescriptor = buildDescriptor("PreventiveAction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.PreventiveAction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("itemReference", ReferenceSerializer.descriptor)
    b.optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.PreventiveAction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.PreventiveAction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item =
        required(
          AdverseEvent.PreventiveAction.Item.from(itemReference, itemCodeableConcept),
          "AdverseEvent.PreventiveAction",
          "item",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.PreventiveAction) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.item) {
      is AdverseEvent.PreventiveAction.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is AdverseEvent.PreventiveAction.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventMitigatingActionSerializer :
  FhirSerializer<AdverseEvent.MitigatingAction> {
  override val descriptor: SerialDescriptor = buildDescriptor("MitigatingAction", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.MitigatingAction>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("itemReference", ReferenceSerializer.descriptor)
    b.optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.MitigatingAction {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.MitigatingAction(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item =
        required(
          AdverseEvent.MitigatingAction.Item.from(itemReference, itemCodeableConcept),
          "AdverseEvent.MitigatingAction",
          "item",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.MitigatingAction) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.item) {
      is AdverseEvent.MitigatingAction.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is AdverseEvent.MitigatingAction.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventSupportingInfoSerializer : FhirSerializer<AdverseEvent.SupportingInfo> {
  override val descriptor: SerialDescriptor = buildDescriptor("SupportingInfo", this)

  @JvmField
  internal val listSerializer: KSerializer<List<AdverseEvent.SupportingInfo>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("itemReference", ReferenceSerializer.descriptor)
    b.optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SupportingInfo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          itemReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          itemCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AdverseEvent.SupportingInfo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item =
        required(
          AdverseEvent.SupportingInfo.Item.from(itemReference, itemCodeableConcept),
          "AdverseEvent.SupportingInfo",
          "item",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SupportingInfo) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.item) {
      is AdverseEvent.SupportingInfo.Item.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
      }
      is AdverseEvent.SupportingInfo.Item.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AdverseEventSerializer : FhirResourceSerializer<AdverseEvent> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AdverseEvent")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.strPrim("actuality")
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.strPrim("occurrenceDateTime")
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurrenceTiming", TimingSerializer.descriptor)
    b.strPrim("detected")
    b.strPrim("recordedDate")
    b.optionalElement("resultingEffect", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("seriousness", CodeableConceptSerializer.descriptor)
    b.optionalElement("outcome", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("recorder", ReferenceSerializer.descriptor)
    b.optionalElement("participant", AdverseEventParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("study", ReferenceSerializer.listSerializer.descriptor)
    b.boolPrim("expectedInResearchStudy")
    b.optionalElement(
      "suspectEntity",
      AdverseEventSuspectEntitySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "contributingFactor",
      AdverseEventContributingFactorSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "preventiveAction",
      AdverseEventPreventiveActionSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "mitigatingAction",
      AdverseEventMitigatingActionSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "supportingInfo",
      AdverseEventSupportingInfoSerializer.listSerializer.descriptor,
    )
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: AdverseEventStatus? = null
    var _status: Element? = null
    var actuality: AdverseEventActuality? = null
    var _actuality: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: FhirDateTime? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var detected: FhirDateTime? = null
    var _detected: Element? = null
    var recordedDate: FhirDateTime? = null
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          status = AdverseEventStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          actuality =
            AdverseEventActuality.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _actuality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          occurrenceDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _occurrenceDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          occurrencePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        22 ->
          occurrenceTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        23 ->
          detected = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _detected =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          recordedDate =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        26 ->
          _recordedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          resultingEffect =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 ->
          seriousness =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        30 ->
          outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          recorder =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        32 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventParticipantSerializer.listSerializer,
              null,
            )
        33 ->
          study =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 -> expectedInResearchStudy = compositeDecoder.decodeBooleanElement(descriptor, i)
        35 ->
          _expectedInResearchStudy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          suspectEntity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSuspectEntitySerializer.listSerializer,
              null,
            )
        37 ->
          contributingFactor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventContributingFactorSerializer.listSerializer,
              null,
            )
        38 ->
          preventiveAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventPreventiveActionSerializer.listSerializer,
              null,
            )
        39 ->
          mitigatingAction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventMitigatingActionSerializer.listSerializer,
              null,
            )
        40 ->
          supportingInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSupportingInfoSerializer.listSerializer,
              null,
            )
        41 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return AdverseEvent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      status = required(Enumeration.of(status, _status), "AdverseEvent", "status"),
      actuality = required(Enumeration.of(actuality, _actuality), "AdverseEvent", "actuality"),
      category = listOrEmpty(category),
      code = code,
      subject = required(subject, "AdverseEvent", "subject"),
      encounter = encounter,
      occurrence =
        AdverseEvent.Occurrence.from(
          DateTime.of(occurrenceDateTime, _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      detected = DateTime.of(detected, _detected),
      recordedDate = DateTime.of(recordedDate, _recordedDate),
      resultingEffect = listOrEmpty(resultingEffect),
      location = location,
      seriousness = seriousness,
      outcome = listOrEmpty(outcome),
      recorder = recorder,
      participant = listOrEmpty(participant),
      study = listOrEmpty(study),
      expectedInResearchStudy = R5Boolean.of(expectedInResearchStudy, _expectedInResearchStudy),
      suspectEntity = listOrEmpty(suspectEntity),
      contributingFactor = listOrEmpty(contributingFactor),
      preventiveAction = listOrEmpty(preventiveAction),
      mitigatingAction = listOrEmpty(mitigatingAction),
      supportingInfo = listOrEmpty(supportingInfo),
      note = listOrEmpty(note),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AdverseEvent,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.actuality.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.actuality)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.occurrence) {
      null -> {}
      is AdverseEvent.Occurrence.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          19 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is AdverseEvent.Occurrence.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is AdverseEvent.Occurrence.Timing -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.detected?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.detected)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.recordedDate)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.resultingEffect,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      CodeableConceptSerializer,
      value.seriousness,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.outcome,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      AdverseEventParticipantSerializer.listSerializer,
      value.participant,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.study,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.expectedInResearchStudy?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.expectedInResearchStudy,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      AdverseEventSuspectEntitySerializer.listSerializer,
      value.suspectEntity,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      37 + descriptorOffset,
      AdverseEventContributingFactorSerializer.listSerializer,
      value.contributingFactor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      38 + descriptorOffset,
      AdverseEventPreventiveActionSerializer.listSerializer,
      value.preventiveAction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      AdverseEventMitigatingActionSerializer.listSerializer,
      value.mitigatingAction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      AdverseEventSupportingInfoSerializer.listSerializer,
      value.supportingInfo,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
  }
}
