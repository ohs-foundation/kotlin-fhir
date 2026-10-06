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
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object AdverseEventParticipantSerializer : KSerializer<AdverseEvent.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.Participant =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: Reference? = null
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
          3 ->
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      AdverseEvent.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on AdverseEvent.Participant"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.Participant) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object AdverseEventSuspectEntitySerializer : KSerializer<AdverseEvent.SuspectEntity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SuspectEntity") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("instanceCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("instanceReference", ReferenceSerializer.descriptor)
      optionalElement("causality", AdverseEventSuspectEntityCausalitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.SuspectEntity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var instanceCodeableConcept: CodeableConcept? = null
      var instanceReference: Reference? = null
      var causality: AdverseEvent.SuspectEntity.Causality? = null
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
          3 ->
            instanceCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            instanceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            causality =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AdverseEventSuspectEntityCausalitySerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SuspectEntity: " + i)
        }
      }
      AdverseEvent.SuspectEntity(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        instance =
          AdverseEvent.SuspectEntity.Instance.from(instanceCodeableConcept, instanceReference)
            ?: throw SerializationException(
              "Missing required property 'instance' on AdverseEvent.SuspectEntity"
            ),
        causality = causality,
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
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
      when (val choice = value.instance) {
        is AdverseEvent.SuspectEntity.Instance.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is AdverseEvent.SuspectEntity.Instance.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(
        descriptor,
        5,
        AdverseEventSuspectEntityCausalitySerializer,
        value.causality,
      )
    }
  }
}

internal object AdverseEventSuspectEntityCausalitySerializer :
  KSerializer<AdverseEvent.SuspectEntity.Causality> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Causality") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("assessmentMethod", CodeableConceptSerializer.descriptor)
      optionalElement("entityRelatedness", CodeableConceptSerializer.descriptor)
      optionalElement("author", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.SuspectEntity.Causality>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var assessmentMethod: CodeableConcept? = null
      var entityRelatedness: CodeableConcept? = null
      var author: Reference? = null
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
          3 ->
            assessmentMethod =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            entityRelatedness =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> author = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Causality: " + i)
        }
      }
      AdverseEvent.SuspectEntity.Causality(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        assessmentMethod = assessmentMethod,
        entityRelatedness = entityRelatedness,
        author = author,
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.assessmentMethod)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.entityRelatedness)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.author)
    }
  }
}

internal object AdverseEventContributingFactorSerializer :
  KSerializer<AdverseEvent.ContributingFactor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContributingFactor") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.ContributingFactor>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.ContributingFactor =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemReference: Reference? = null
      var itemCodeableConcept: CodeableConcept? = null
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
          3 ->
            itemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            itemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ContributingFactor: " + i)
        }
      }
      AdverseEvent.ContributingFactor(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          AdverseEvent.ContributingFactor.Item.from(itemReference, itemCodeableConcept)
            ?: throw SerializationException(
              "Missing required property 'item' on AdverseEvent.ContributingFactor"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.ContributingFactor) {
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
      when (val choice = value.item) {
        is AdverseEvent.ContributingFactor.Item.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is AdverseEvent.ContributingFactor.Item.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object AdverseEventPreventiveActionSerializer :
  KSerializer<AdverseEvent.PreventiveAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PreventiveAction") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.PreventiveAction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.PreventiveAction =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemReference: Reference? = null
      var itemCodeableConcept: CodeableConcept? = null
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
          3 ->
            itemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            itemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PreventiveAction: " + i)
        }
      }
      AdverseEvent.PreventiveAction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          AdverseEvent.PreventiveAction.Item.from(itemReference, itemCodeableConcept)
            ?: throw SerializationException(
              "Missing required property 'item' on AdverseEvent.PreventiveAction"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.PreventiveAction) {
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
      when (val choice = value.item) {
        is AdverseEvent.PreventiveAction.Item.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is AdverseEvent.PreventiveAction.Item.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object AdverseEventMitigatingActionSerializer :
  KSerializer<AdverseEvent.MitigatingAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MitigatingAction") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.MitigatingAction>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.MitigatingAction =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemReference: Reference? = null
      var itemCodeableConcept: CodeableConcept? = null
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
          3 ->
            itemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            itemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MitigatingAction: " + i)
        }
      }
      AdverseEvent.MitigatingAction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          AdverseEvent.MitigatingAction.Item.from(itemReference, itemCodeableConcept)
            ?: throw SerializationException(
              "Missing required property 'item' on AdverseEvent.MitigatingAction"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.MitigatingAction) {
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
      when (val choice = value.item) {
        is AdverseEvent.MitigatingAction.Item.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is AdverseEvent.MitigatingAction.Item.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object AdverseEventSupportingInfoSerializer : KSerializer<AdverseEvent.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemReference", ReferenceSerializer.descriptor)
      optionalElement("itemCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdverseEvent.SupportingInfo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdverseEvent.SupportingInfo =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemReference: Reference? = null
      var itemCodeableConcept: CodeableConcept? = null
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
          3 ->
            itemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            itemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
        }
      }
      AdverseEvent.SupportingInfo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          AdverseEvent.SupportingInfo.Item.from(itemReference, itemCodeableConcept)
            ?: throw SerializationException(
              "Missing required property 'item' on AdverseEvent.SupportingInfo"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SupportingInfo) {
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
      when (val choice = value.item) {
        is AdverseEvent.SupportingInfo.Item.Reference -> {
          encodeSerializableElement(descriptor, 3, ReferenceSerializer, choice.value)
        }
        is AdverseEvent.SupportingInfo.Item.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object AdverseEventSerializer : FhirResourceSerializer<AdverseEvent> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AdverseEvent")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("actuality", String.serializer().descriptor)
    b.optionalElement("_actuality", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", String.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("occurrenceTiming", TimingSerializer.descriptor)
    b.optionalElement("detected", String.serializer().descriptor)
    b.optionalElement("_detected", ElementSerializer.descriptor)
    b.optionalElement("recordedDate", String.serializer().descriptor)
    b.optionalElement("_recordedDate", ElementSerializer.descriptor)
    b.optionalElement("resultingEffect", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("seriousness", CodeableConceptSerializer.descriptor)
    b.optionalElement("outcome", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("recorder", ReferenceSerializer.descriptor)
    b.optionalElement("participant", AdverseEventParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("study", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("expectedInResearchStudy", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_expectedInResearchStudy", ElementSerializer.descriptor)
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> actuality = decoder.decodeStringElement(descriptor, i)
        14 ->
          _actuality =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        22 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        23 -> detected = decoder.decodeStringElement(descriptor, i)
        24 ->
          _detected =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        26 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          resultingEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          seriousness =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        30 ->
          outcome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventParticipantSerializer.listSerializer,
              null,
            )
        33 ->
          study =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 -> expectedInResearchStudy = decoder.decodeBooleanElement(descriptor, i)
        35 ->
          _expectedInResearchStudy =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSuspectEntitySerializer.listSerializer,
              null,
            )
        37 ->
          contributingFactor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventContributingFactorSerializer.listSerializer,
              null,
            )
        38 ->
          preventiveAction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventPreventiveActionSerializer.listSerializer,
              null,
            )
        39 ->
          mitigatingAction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventMitigatingActionSerializer.listSerializer,
              null,
            )
        40 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdverseEventSupportingInfoSerializer.listSerializer,
              null,
            )
        41 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
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
      status =
        Enumeration.of(
          if (status != null) AdverseEvent.AdverseEventStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on AdverseEvent"),
      actuality =
        Enumeration.of(
          if (actuality != null) AdverseEvent.AdverseEventActuality.fromCode(actuality) else null,
          _actuality,
        ) ?: throw SerializationException("Missing required property 'actuality' on AdverseEvent"),
      category = category ?: listOf(),
      code = code,
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on AdverseEvent"),
      encounter = encounter,
      occurrence =
        AdverseEvent.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          occurrencePeriod,
          occurrenceTiming,
        ),
      detected =
        DateTime.of(if (detected != null) FhirDateTime.fromString(detected) else null, _detected),
      recordedDate =
        DateTime.of(
          if (recordedDate != null) FhirDateTime.fromString(recordedDate) else null,
          _recordedDate,
        ),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AdverseEvent,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.actuality.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.actuality)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.occurrence) {
      null -> {}
      is AdverseEvent.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          19 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is AdverseEvent.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is AdverseEvent.Occurrence.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.detected?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.detected)
    encoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.recordedDate)
    if (value.resultingEffect.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.resultingEffect,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      CodeableConceptSerializer,
      value.seriousness,
    )
    if (value.outcome.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.outcome,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        AdverseEventParticipantSerializer.listSerializer,
        value.participant,
      )
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.study,
      )
    encoder.encodeBooleanIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.expectedInResearchStudy?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.expectedInResearchStudy)
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        AdverseEventSuspectEntitySerializer.listSerializer,
        value.suspectEntity,
      )
    if (value.contributingFactor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        AdverseEventContributingFactorSerializer.listSerializer,
        value.contributingFactor,
      )
    if (value.preventiveAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        AdverseEventPreventiveActionSerializer.listSerializer,
        value.preventiveAction,
      )
    if (value.mitigatingAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        AdverseEventMitigatingActionSerializer.listSerializer,
        value.mitigatingAction,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        AdverseEventSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
