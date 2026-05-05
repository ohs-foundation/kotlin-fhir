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
import kotlin.String as KotlinString
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Label) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.Label {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> `value` = decoder.decodeStringElement(__desc, 4)
        5 -> _value = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Label: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.Label) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.valueSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.AssociatedParty) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.AssociatedParty {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> role = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.roleSer, null)
        6 -> period = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.periodSer, null)
        7 ->
          classifier =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.classifierSer, null)
        8 -> party = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AssociatedParty: " + __i)
      }
    }
    return ResearchStudy.AssociatedParty(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name),
      role = role!!,
      period = period ?: listOf(),
      classifier = classifier ?: listOf(),
      party = party,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.AssociatedParty) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.roleSer, it) }
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.periodSer, value.period)
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.classifierSer, value.classifier)
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.partySer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ProgressStatus) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.ProgressStatus {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var state: CodeableConcept? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> state = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.stateSer, null)
        4 -> `actual` = decoder.decodeBooleanElement(__desc, 4)
        5 -> _actual = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.actualSer, null)
        6 -> period = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProgressStatus: " + __i)
      }
    }
    return ResearchStudy.ProgressStatus(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      state = state!!,
      `actual` = R5Boolean.of(`actual`, _actual),
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.ProgressStatus) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.state)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.stateSer, it) }
    ((value.`actual`?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.`actual`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.actualSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.periodSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Recruitment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.Recruitment {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> targetNumber = decoder.decodeIntElement(__desc, 3)
        4 ->
          _targetNumber =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.targetNumberSer, null)
        5 -> actualNumber = decoder.decodeIntElement(__desc, 5)
        6 ->
          _actualNumber =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.targetNumberSer, null)
        7 ->
          eligibility =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.eligibilitySer, null)
        8 ->
          actualGroup =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.eligibilitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Recruitment: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.Recruitment) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.targetNumber?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.targetNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.targetNumberSer, it)
    }
    ((value.actualNumber?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.actualNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.targetNumberSer, it)
    }
    (value.eligibility)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.eligibilitySer, it)
    }
    (value.actualGroup)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.eligibilitySer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ComparisonGroup) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.ComparisonGroup {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> name = decoder.decodeStringElement(__desc, 5)
        6 -> _name = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.linkIdSer, null)
        7 -> type = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 -> description = decoder.decodeStringElement(__desc, 8)
        9 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.linkIdSer, null)
        10 ->
          intendedExposure =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.intendedExposureSer, null)
        11 ->
          observedGroup =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.intendedExposureSerInner,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ComparisonGroup: " + __i)
      }
    }
    return ResearchStudy.ComparisonGroup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = Id.of(linkId, _linkId),
      name = R5String.of(name, _name)!!,
      type = type,
      description = Markdown.of(description, _description),
      intendedExposure = intendedExposure ?: listOf(),
      observedGroup = observedGroup,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.ComparisonGroup) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.linkIdSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.linkIdSer, it)
    }
    if (value.intendedExposure.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        10,
        Hoisted.intendedExposureSer,
        value.intendedExposure,
      )
    (value.observedGroup)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.intendedExposureSerInner, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Objective) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.Objective {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(__desc, 6)
        7 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Objective: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.Objective) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.OutcomeMeasure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchStudy.OutcomeMeasure {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> description = decoder.decodeStringElement(__desc, 6)
        7 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.nameSer, null)
        8 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OutcomeMeasure: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy.OutcomeMeasure) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, value.type)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.nameSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.referenceSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ResearchStudy")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ResearchStudy {
    val __desc = descriptor
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> label = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.labelSer, null)
        21 ->
          protocol =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.protocolSer, null)
        22 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.protocolSer, null)
        23 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.relatedArtifactSer, null)
        24 -> date = decoder.decodeStringElement(__desc, 24)
        25 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> status = decoder.decodeStringElement(__desc, 26)
        27 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          primaryPurposeType =
            decoder.decodeNullableSerializableElement(
              __desc,
              28,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        29 ->
          phase =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        30 ->
          studyDesign =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.studyDesignSer, null)
        31 -> focus = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.focusSer, null)
        32 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.studyDesignSer, null)
        33 ->
          keyword =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.studyDesignSer, null)
        34 ->
          region =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.studyDesignSer, null)
        35 -> descriptionSummary = decoder.decodeStringElement(__desc, 35)
        36 ->
          _descriptionSummary =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 -> description = decoder.decodeStringElement(__desc, 37)
        38 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 ->
          period = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.periodSer, null)
        40 ->
          site = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.protocolSer, null)
        41 -> note = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.noteSer, null)
        42 ->
          classifier =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.studyDesignSer, null)
        43 ->
          associatedParty =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.associatedPartySer, null)
        44 ->
          progressStatus =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.progressStatusSer, null)
        45 ->
          whyStopped =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.primaryPurposeTypeSer,
              null,
            )
        46 ->
          recruitment =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.recruitmentSer, null)
        47 ->
          comparisonGroup =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.comparisonGroupSer, null)
        48 ->
          objective =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.objectiveSer, null)
        49 ->
          outcomeMeasure =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.outcomeMeasureSer, null)
        50 ->
          result = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.protocolSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ResearchStudy: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: ResearchStudy) {
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.label.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.labelSer, value.label)
    if (value.protocol.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.protocolSer, value.protocol)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.protocolSer, value.partOf)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    (value.primaryPurposeType)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.primaryPurposeTypeSer, it)
    }
    (value.phase)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.primaryPurposeTypeSer, it)
    }
    if (value.studyDesign.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.studyDesignSer, value.studyDesign)
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.focusSer, value.focus)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.studyDesignSer, value.condition)
    if (value.keyword.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.studyDesignSer, value.keyword)
    if (value.region.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.studyDesignSer, value.region)
    ((value.descriptionSummary?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.descriptionSummary?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 39, Hoisted.periodSer, it) }
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.protocolSer, value.site)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.noteSer, value.note)
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.studyDesignSer, value.classifier)
    if (value.associatedParty.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43,
        Hoisted.associatedPartySer,
        value.associatedParty,
      )
    if (value.progressStatus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.progressStatusSer, value.progressStatus)
    (value.whyStopped)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.primaryPurposeTypeSer, it)
    }
    (value.recruitment)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.recruitmentSer, it)
    }
    if (value.comparisonGroup.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        47,
        Hoisted.comparisonGroupSer,
        value.comparisonGroup,
      )
    if (value.objective.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.objectiveSer, value.objective)
    if (value.outcomeMeasure.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.outcomeMeasureSer, value.outcomeMeasure)
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.protocolSer, value.result)
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
    encoder.encodeStructure(descriptor) { ResearchStudySerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    decoder.decodeStructure(descriptor) { ResearchStudySerializer.deserializeJson(this) }
}
