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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.Label =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Label) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.Label {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> `value` = decoder.decodeStringElement(descriptor, i)
        5 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Label: " + i)
      }
    }
    return ResearchStudy.Label(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      `value` = R5String.of(`value`, _value),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.Label) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ResearchStudyAssociatedPartySerializer :
  KSerializer<ResearchStudy.AssociatedParty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AssociatedParty") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("period", listSerialDescriptor(Period.serializer().descriptor), isOptional = true)
      element(
        "classifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("party", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.AssociatedParty =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.AssociatedParty) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.AssociatedParty {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        6 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        7 ->
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classifierSer, null)
        8 ->
          party = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AssociatedParty: " + i)
      }
    }
    return ResearchStudy.AssociatedParty(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.AssociatedParty) {
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
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.roleSer, value.role)
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.periodSer, value.period)
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.classifierSer, value.classifier)
    (value.party)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.partySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSerInner: KSerializer<Period> = Period.serializer()

    public val periodSer: KSerializer<List<Period>> = ListSerializer(Hoisted.periodSerInner)

    public val classifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.roleSer)

    public val partySer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ResearchStudyProgressStatusSerializer : KSerializer<ResearchStudy.ProgressStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProgressStatus") {
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
      element("state", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actual", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_actual", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.ProgressStatus =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ProgressStatus) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.ProgressStatus {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var state: CodeableConcept? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var period: Period? = null
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
          state = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.stateSer, null)
        4 -> `actual` = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _actual =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actualSer, null)
        6 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProgressStatus: " + i)
      }
    }
    return ResearchStudy.ProgressStatus(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.ProgressStatus) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.stateSer, value.state)
    ((value.`actual`?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.`actual`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.actualSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val stateSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actualSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object ResearchStudyRecruitmentSerializer : KSerializer<ResearchStudy.Recruitment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Recruitment") {
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
      element("targetNumber", Int.serializer().descriptor, isOptional = true)
      element("_targetNumber", Element.serializer().descriptor, isOptional = true)
      element("actualNumber", Int.serializer().descriptor, isOptional = true)
      element("_actualNumber", Element.serializer().descriptor, isOptional = true)
      element("eligibility", Reference.serializer().descriptor, isOptional = true)
      element("actualGroup", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.Recruitment =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Recruitment) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.Recruitment {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> targetNumber = decoder.decodeIntElement(descriptor, i)
        4 ->
          _targetNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetNumberSer, null)
        5 -> actualNumber = decoder.decodeIntElement(descriptor, i)
        6 ->
          _actualNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetNumberSer, null)
        7 ->
          eligibility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eligibilitySer, null)
        8 ->
          actualGroup =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eligibilitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Recruitment: " + i)
      }
    }
    return ResearchStudy.Recruitment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      targetNumber = UnsignedInt.of(targetNumber, _targetNumber),
      actualNumber = UnsignedInt.of(actualNumber, _actualNumber),
      eligibility = eligibility,
      actualGroup = actualGroup,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.Recruitment) {
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
    ((value.targetNumber?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.targetNumber?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.targetNumberSer, it)
    }
    ((value.actualNumber?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.actualNumber?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.targetNumberSer, it)
    }
    (value.eligibility)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.eligibilitySer, it)
    }
    (value.actualGroup)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.eligibilitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val targetNumberSer: KSerializer<Element> = Element.serializer()

    public val eligibilitySer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ResearchStudyComparisonGroupSerializer :
  KSerializer<ResearchStudy.ComparisonGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ComparisonGroup") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "intendedExposure",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("observedGroup", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.ComparisonGroup =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ComparisonGroup) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.ComparisonGroup {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> name = decoder.decodeStringElement(descriptor, i)
        6 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        7 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 -> description = decoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        10 ->
          intendedExposure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.intendedExposureSer,
              null,
            )
        11 ->
          observedGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.intendedExposureSerInner,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ComparisonGroup: " + i)
      }
    }
    return ResearchStudy.ComparisonGroup(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.ComparisonGroup) {
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.linkIdSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.linkIdSer, it)
    }
    if (value.intendedExposure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        Hoisted.intendedExposureSer,
        value.intendedExposure,
      )
    (value.observedGroup)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.intendedExposureSerInner, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val intendedExposureSerInner: KSerializer<Reference> = Reference.serializer()

    public val intendedExposureSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.intendedExposureSerInner)
  }
}

internal object ResearchStudyObjectiveSerializer : KSerializer<ResearchStudy.Objective> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Objective") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.Objective =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Objective) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.Objective {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Objective: " + i)
      }
    }
    return ResearchStudy.Objective(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name),
      type = type,
      description = Markdown.of(description, _description),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.Objective) {
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
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ResearchStudyOutcomeMeasureSerializer : KSerializer<ResearchStudy.OutcomeMeasure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OutcomeMeasure") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchStudy.OutcomeMeasure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.OutcomeMeasure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchStudy.OutcomeMeasure {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(descriptor, i)
        7 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        8 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OutcomeMeasure: " + i)
      }
    }
    return ResearchStudy.OutcomeMeasure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name),
      type = type ?: listOf(),
      description = Markdown.of(description, _description),
      reference = reference,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchStudy.OutcomeMeasure) {
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
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, value.type)
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.nameSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ResearchStudySerializer : KSerializer<ResearchStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchStudy") {
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
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element(
      "label",
      listSerialDescriptor(lazyDescriptor { ResearchStudy.Label.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "protocol",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("primaryPurposeType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("phase", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "studyDesign",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "focus",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "condition",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "keyword",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "region",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("descriptionSummary", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_descriptionSummary", Element.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("site", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "classifier",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "associatedParty",
      listSerialDescriptor(
        lazyDescriptor { ResearchStudy.AssociatedParty.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "progressStatus",
      listSerialDescriptor(lazyDescriptor { ResearchStudy.ProgressStatus.serializer().descriptor }),
      isOptional = true,
    )
    b.element("whyStopped", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "recruitment",
      lazyDescriptor { ResearchStudy.Recruitment.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "comparisonGroup",
      listSerialDescriptor(
        lazyDescriptor { ResearchStudy.ComparisonGroup.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "objective",
      listSerialDescriptor(lazyDescriptor { ResearchStudy.Objective.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "outcomeMeasure",
      listSerialDescriptor(lazyDescriptor { ResearchStudy.OutcomeMeasure.serializer().descriptor }),
      isOptional = true,
    )
    b.element("result", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ResearchStudy")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.labelSer, null)
        20 ->
          protocol =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        21 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        22 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> status = decoder.decodeStringElement(descriptor, i)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          primaryPurposeType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        28 ->
          phase =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        29 ->
          studyDesign =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studyDesignSer, null)
        30 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focusSer, null)
        31 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studyDesignSer, null)
        32 ->
          keyword =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studyDesignSer, null)
        33 ->
          region =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studyDesignSer, null)
        34 -> descriptionSummary = decoder.decodeStringElement(descriptor, i)
        35 ->
          _descriptionSummary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 -> description = decoder.decodeStringElement(descriptor, i)
        37 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        38 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        39 ->
          site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
        40 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        41 ->
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studyDesignSer, null)
        42 ->
          associatedParty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.associatedPartySer,
              null,
            )
        43 ->
          progressStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.progressStatusSer,
              null,
            )
        44 ->
          whyStopped =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        45 ->
          recruitment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.recruitmentSer, null)
        46 ->
          comparisonGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.comparisonGroupSer,
              null,
            )
        47 ->
          objective =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.objectiveSer, null)
        48 ->
          outcomeMeasure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.outcomeMeasureSer,
              null,
            )
        49 ->
          result =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.protocolSer, null)
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
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchStudy,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
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
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.label.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.labelSer,
        value.label,
      )
    if (value.protocol.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.protocolSer,
        value.protocol,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.protocolSer,
        value.partOf,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
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
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.primaryPurposeType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.primaryPurposeTypeSer,
        it,
      )
    }
    (value.phase)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.primaryPurposeTypeSer,
        it,
      )
    }
    if (value.studyDesign.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.studyDesignSer,
        value.studyDesign,
      )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.focusSer,
        value.focus,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.studyDesignSer,
        value.condition,
      )
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.studyDesignSer,
        value.keyword,
      )
    if (value.region.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.studyDesignSer,
        value.region,
      )
    ((value.descriptionSummary?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.descriptionSummary?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 36 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, Hoisted.periodSer, it)
    }
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.protocolSer,
        value.site,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.studyDesignSer,
        value.classifier,
      )
    if (value.associatedParty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.associatedPartySer,
        value.associatedParty,
      )
    if (value.progressStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.progressStatusSer,
        value.progressStatus,
      )
    (value.whyStopped)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.primaryPurposeTypeSer,
        it,
      )
    }
    (value.recruitment)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.recruitmentSer,
        it,
      )
    }
    if (value.comparisonGroup.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.comparisonGroupSer,
        value.comparisonGroup,
      )
    if (value.objective.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.objectiveSer,
        value.objective,
      )
    if (value.outcomeMeasure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.outcomeMeasureSer,
        value.outcomeMeasure,
      )
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.protocolSer,
        value.result,
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

    public val labelSerInner: KSerializer<ResearchStudy.Label> = ResearchStudy.Label.serializer()

    public val labelSer: KSerializer<List<ResearchStudy.Label>> =
      ListSerializer(Hoisted.labelSerInner)

    public val protocolSerInner: KSerializer<Reference> = Reference.serializer()

    public val protocolSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.protocolSerInner)

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val primaryPurposeTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val studyDesignSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.primaryPurposeTypeSer)

    public val focusSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val focusSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.focusSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val associatedPartySerInner: KSerializer<ResearchStudy.AssociatedParty> =
      ResearchStudy.AssociatedParty.serializer()

    public val associatedPartySer: KSerializer<List<ResearchStudy.AssociatedParty>> =
      ListSerializer(Hoisted.associatedPartySerInner)

    public val progressStatusSerInner: KSerializer<ResearchStudy.ProgressStatus> =
      ResearchStudy.ProgressStatus.serializer()

    public val progressStatusSer: KSerializer<List<ResearchStudy.ProgressStatus>> =
      ListSerializer(Hoisted.progressStatusSerInner)

    public val recruitmentSer: KSerializer<ResearchStudy.Recruitment> =
      ResearchStudy.Recruitment.serializer()

    public val comparisonGroupSerInner: KSerializer<ResearchStudy.ComparisonGroup> =
      ResearchStudy.ComparisonGroup.serializer()

    public val comparisonGroupSer: KSerializer<List<ResearchStudy.ComparisonGroup>> =
      ListSerializer(Hoisted.comparisonGroupSerInner)

    public val objectiveSerInner: KSerializer<ResearchStudy.Objective> =
      ResearchStudy.Objective.serializer()

    public val objectiveSer: KSerializer<List<ResearchStudy.Objective>> =
      ListSerializer(Hoisted.objectiveSerInner)

    public val outcomeMeasureSerInner: KSerializer<ResearchStudy.OutcomeMeasure> =
      ResearchStudy.OutcomeMeasure.serializer()

    public val outcomeMeasureSer: KSerializer<List<ResearchStudy.OutcomeMeasure>> =
      ListSerializer(Hoisted.outcomeMeasureSerInner)
  }
}

internal object ResearchStudyPolymorphicSerializer : KSerializer<ResearchStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchStudy") { ResearchStudySerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) {
      ResearchStudySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) {
      ResearchStudySerializer.deserializeInternal(this, descriptor, 0)
    }
}
