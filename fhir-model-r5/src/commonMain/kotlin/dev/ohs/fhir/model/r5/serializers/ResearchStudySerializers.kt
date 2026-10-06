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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.ResearchStudy
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object ResearchStudyLabelSerializer : KSerializer<ResearchStudy.Label> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Label") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.Label>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.Label =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `value` = decodeStringElement(descriptor, i)
          5 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Label: " + i)
        }
      }
      ResearchStudy.Label(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        `value` = R5String.of(`value`, _value),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Label) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 5, value.`value`)
    }
  }
}

internal object ResearchStudyAssociatedPartySerializer :
  KSerializer<ResearchStudy.AssociatedParty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AssociatedParty") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("period", PeriodSerializer.listSerializer.descriptor)
      optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.AssociatedParty>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.AssociatedParty =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var role: CodeableConcept? = null
      var period: List<Period>? = null
      var classifier: List<CodeableConcept>? = null
      var party: Reference? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            period =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PeriodSerializer.listSerializer,
                null,
              )
          7 ->
            classifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AssociatedParty: " + i)
        }
      }
      ResearchStudy.AssociatedParty(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = R5String.of(name, _name),
        role =
          role
            ?: throw SerializationException(
              "Missing required property 'role' on ResearchStudy.AssociatedParty"
            ),
        period = period ?: listOf(),
        classifier = classifier ?: listOf(),
        party = party,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.AssociatedParty) {
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.role)
      if (value.period.isNotEmpty())
        encodeSerializableElement(descriptor, 6, PeriodSerializer.listSerializer, value.period)
      if (value.classifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.classifier,
        )
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.party)
    }
  }
}

internal object ResearchStudyProgressStatusSerializer : KSerializer<ResearchStudy.ProgressStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProgressStatus") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("state", CodeableConceptSerializer.descriptor)
      optionalElement("actual", KotlinBoolean.serializer().descriptor)
      optionalElement("_actual", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.ProgressStatus>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.ProgressStatus =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var state: CodeableConcept? = null
      var `actual`: KotlinBoolean? = null
      var _actual: Element? = null
      var period: Period? = null
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
            state =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `actual` = decodeBooleanElement(descriptor, i)
          5 -> _actual = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProgressStatus: " + i)
        }
      }
      ResearchStudy.ProgressStatus(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        state =
          state
            ?: throw SerializationException(
              "Missing required property 'state' on ResearchStudy.ProgressStatus"
            ),
        `actual` = R5Boolean.of(`actual`, _actual),
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ProgressStatus) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.state)
      encodeBooleanIfNotNull(descriptor, 4, value.`actual`?.value)
      encodeElementIfNotNull(descriptor, 5, value.`actual`)
      encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.period)
    }
  }
}

internal object ResearchStudyRecruitmentSerializer : KSerializer<ResearchStudy.Recruitment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Recruitment") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("targetNumber", Int.serializer().descriptor)
      optionalElement("_targetNumber", ElementSerializer.descriptor)
      optionalElement("actualNumber", Int.serializer().descriptor)
      optionalElement("_actualNumber", ElementSerializer.descriptor)
      optionalElement("eligibility", ReferenceSerializer.descriptor)
      optionalElement("actualGroup", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.Recruitment>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.Recruitment =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var targetNumber: Int? = null
      var _targetNumber: Element? = null
      var actualNumber: Int? = null
      var _actualNumber: Element? = null
      var eligibility: Reference? = null
      var actualGroup: Reference? = null
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
          3 -> targetNumber = decodeIntElement(descriptor, i)
          4 ->
            _targetNumber =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> actualNumber = decodeIntElement(descriptor, i)
          6 ->
            _actualNumber =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            eligibility =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            actualGroup =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Recruitment: " + i)
        }
      }
      ResearchStudy.Recruitment(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        targetNumber = UnsignedInt.of(targetNumber, _targetNumber),
        actualNumber = UnsignedInt.of(actualNumber, _actualNumber),
        eligibility = eligibility,
        actualGroup = actualGroup,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Recruitment) {
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
      encodeIntIfNotNull(descriptor, 3, value.targetNumber?.value)
      encodeElementIfNotNull(descriptor, 4, value.targetNumber)
      encodeIntIfNotNull(descriptor, 5, value.actualNumber?.value)
      encodeElementIfNotNull(descriptor, 6, value.actualNumber)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.eligibility)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.actualGroup)
    }
  }
}

internal object ResearchStudyComparisonGroupSerializer :
  KSerializer<ResearchStudy.ComparisonGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ComparisonGroup") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("intendedExposure", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("observedGroup", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.ComparisonGroup>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.ComparisonGroup =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var linkId: KotlinString? = null
      var _linkId: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var type: CodeableConcept? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var intendedExposure: List<Reference>? = null
      var observedGroup: Reference? = null
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> name = decodeStringElement(descriptor, i)
          6 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 -> description = decodeStringElement(descriptor, i)
          9 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            intendedExposure =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          11 ->
            observedGroup =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ComparisonGroup: " + i)
        }
      }
      ResearchStudy.ComparisonGroup(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = Id.of(linkId, _linkId),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on ResearchStudy.ComparisonGroup"
            ),
        type = type,
        description = Markdown.of(description, _description),
        intendedExposure = intendedExposure ?: listOf(),
        observedGroup = observedGroup,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ComparisonGroup) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeStringIfNotNull(descriptor, 5, value.name.value)
      encodeElementIfNotNull(descriptor, 6, value.name)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 8, value.description?.value)
      encodeElementIfNotNull(descriptor, 9, value.description)
      if (value.intendedExposure.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          ReferenceSerializer.listSerializer,
          value.intendedExposure,
        )
      encodeSerializableIfNotNull(descriptor, 11, ReferenceSerializer, value.observedGroup)
    }
  }
}

internal object ResearchStudyObjectiveSerializer : KSerializer<ResearchStudy.Objective> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Objective") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.Objective>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.Objective =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var type: CodeableConcept? = null
      var description: KotlinString? = null
      var _description: Element? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> description = decodeStringElement(descriptor, i)
          7 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Objective: " + i)
        }
      }
      ResearchStudy.Objective(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = R5String.of(name, _name),
        type = type,
        description = Markdown.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Objective) {
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 6, value.description?.value)
      encodeElementIfNotNull(descriptor, 7, value.description)
    }
  }
}

internal object ResearchStudyOutcomeMeasureSerializer : KSerializer<ResearchStudy.OutcomeMeasure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OutcomeMeasure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchStudy.OutcomeMeasure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchStudy.OutcomeMeasure =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var type: List<CodeableConcept>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var reference: Reference? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 -> description = decodeStringElement(descriptor, i)
          7 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding OutcomeMeasure: " + i)
        }
      }
      ResearchStudy.OutcomeMeasure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = R5String.of(name, _name),
        type = type ?: listOf(),
        description = Markdown.of(description, _description),
        reference = reference,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.OutcomeMeasure) {
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      encodeStringIfNotNull(descriptor, 6, value.description?.value)
      encodeElementIfNotNull(descriptor, 7, value.description)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.reference)
    }
  }
}

internal object ResearchStudySerializer : FhirResourceSerializer<ResearchStudy> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ResearchStudy")

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
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("label", ResearchStudyLabelSerializer.listSerializer.descriptor)
    b.optionalElement("protocol", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("primaryPurposeType", CodeableConceptSerializer.descriptor)
    b.optionalElement("phase", CodeableConceptSerializer.descriptor)
    b.optionalElement("studyDesign", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("focus", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("condition", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("keyword", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("region", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("descriptionSummary", KotlinString.serializer().descriptor)
    b.optionalElement("_descriptionSummary", ElementSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("site", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "associatedParty",
      ResearchStudyAssociatedPartySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "progressStatus",
      ResearchStudyProgressStatusSerializer.listSerializer.descriptor,
    )
    b.optionalElement("whyStopped", CodeableConceptSerializer.descriptor)
    b.optionalElement("recruitment", ResearchStudyRecruitmentSerializer.descriptor)
    b.optionalElement(
      "comparisonGroup",
      ResearchStudyComparisonGroupSerializer.listSerializer.descriptor,
    )
    b.optionalElement("objective", ResearchStudyObjectiveSerializer.listSerializer.descriptor)
    b.optionalElement(
      "outcomeMeasure",
      ResearchStudyOutcomeMeasureSerializer.listSerializer.descriptor,
    )
    b.optionalElement("result", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ResearchStudy {
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
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var label: List<ResearchStudy.Label>? = null
    var protocol: List<Reference>? = null
    var partOf: List<Reference>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var primaryPurposeType: CodeableConcept? = null
    var phase: CodeableConcept? = null
    var studyDesign: List<CodeableConcept>? = null
    var focus: List<CodeableReference>? = null
    var condition: List<CodeableConcept>? = null
    var keyword: List<CodeableConcept>? = null
    var region: List<CodeableConcept>? = null
    var descriptionSummary: KotlinString? = null
    var _descriptionSummary: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var period: Period? = null
    var site: List<Reference>? = null
    var note: List<Annotation>? = null
    var classifier: List<CodeableConcept>? = null
    var associatedParty: List<ResearchStudy.AssociatedParty>? = null
    var progressStatus: List<ResearchStudy.ProgressStatus>? = null
    var whyStopped: CodeableConcept? = null
    var recruitment: ResearchStudy.Recruitment? = null
    var comparisonGroup: List<ResearchStudy.ComparisonGroup>? = null
    var objective: List<ResearchStudy.Objective>? = null
    var outcomeMeasure: List<ResearchStudy.OutcomeMeasure>? = null
    var result: List<Reference>? = null
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
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          label =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyLabelSerializer.listSerializer,
              null,
            )
        20 ->
          protocol =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> status = decoder.decodeStringElement(descriptor, i)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          primaryPurposeType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          phase =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        29 ->
          studyDesign =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        30 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        31 ->
          condition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 ->
          keyword =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        33 ->
          region =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        34 -> descriptionSummary = decoder.decodeStringElement(descriptor, i)
        35 ->
          _descriptionSummary =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> description = decoder.decodeStringElement(descriptor, i)
        37 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        39 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        40 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        41 ->
          classifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        42 ->
          associatedParty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyAssociatedPartySerializer.listSerializer,
              null,
            )
        43 ->
          progressStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyProgressStatusSerializer.listSerializer,
              null,
            )
        44 ->
          whyStopped =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        45 ->
          recruitment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyRecruitmentSerializer,
              null,
            )
        46 ->
          comparisonGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyComparisonGroupSerializer.listSerializer,
              null,
            )
        47 ->
          objective =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyObjectiveSerializer.listSerializer,
              null,
            )
        48 ->
          outcomeMeasure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchStudyOutcomeMeasureSerializer.listSerializer,
              null,
            )
        49 ->
          result =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ResearchStudy: " + i)
      }
    }
    return ResearchStudy(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      label = label ?: listOf(),
      protocol = protocol ?: listOf(),
      partOf = partOf ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on ResearchStudy"),
      primaryPurposeType = primaryPurposeType,
      phase = phase,
      studyDesign = studyDesign ?: listOf(),
      focus = focus ?: listOf(),
      condition = condition ?: listOf(),
      keyword = keyword ?: listOf(),
      region = region ?: listOf(),
      descriptionSummary = Markdown.of(descriptionSummary, _descriptionSummary),
      description = Markdown.of(description, _description),
      period = period,
      site = site ?: listOf(),
      note = note ?: listOf(),
      classifier = classifier ?: listOf(),
      associatedParty = associatedParty ?: listOf(),
      progressStatus = progressStatus ?: listOf(),
      whyStopped = whyStopped,
      recruitment = recruitment,
      comparisonGroup = comparisonGroup ?: listOf(),
      objective = objective ?: listOf(),
      outcomeMeasure = outcomeMeasure ?: listOf(),
      result = result ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchStudy,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    if (value.label.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ResearchStudyLabelSerializer.listSerializer,
        value.label,
      )
    if (value.protocol.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.protocol,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.primaryPurposeType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer,
      value.phase,
    )
    if (value.studyDesign.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.studyDesign,
      )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.focus,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.condition,
      )
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.keyword,
      )
    if (value.region.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.region,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.descriptionSummary?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.descriptionSummary)
    encoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.description)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.site,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.classifier,
      )
    if (value.associatedParty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ResearchStudyAssociatedPartySerializer.listSerializer,
        value.associatedParty,
      )
    if (value.progressStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ResearchStudyProgressStatusSerializer.listSerializer,
        value.progressStatus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      CodeableConceptSerializer,
      value.whyStopped,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      ResearchStudyRecruitmentSerializer,
      value.recruitment,
    )
    if (value.comparisonGroup.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ResearchStudyComparisonGroupSerializer.listSerializer,
        value.comparisonGroup,
      )
    if (value.objective.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ResearchStudyObjectiveSerializer.listSerializer,
        value.objective,
      )
    if (value.outcomeMeasure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ResearchStudyOutcomeMeasureSerializer.listSerializer,
        value.outcomeMeasure,
      )
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.result,
      )
  }
}
