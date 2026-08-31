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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.ResearchSubject
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object ResearchSubjectProgressSerializer : KSerializer<ResearchSubject.Progress> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Progress") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectState", CodeableConcept.serializer().descriptor, isOptional = true)
      element("milestone", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("startDate", String.serializer().descriptor, isOptional = true)
      element("_startDate", Element.serializer().descriptor, isOptional = true)
      element("endDate", String.serializer().descriptor, isOptional = true)
      element("_endDate", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ResearchSubject.Progress =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchSubject.Progress) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ResearchSubject.Progress {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var subjectState: CodeableConcept? = null
    var milestone: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var startDate: String? = null
    var _startDate: Element? = null
    var endDate: String? = null
    var _endDate: Element? = null
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
        4 ->
          subjectState =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          milestone =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> startDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _startDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startDateSer, null)
        9 -> endDate = decoder.decodeStringElement(descriptor, i)
        10 ->
          _endDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startDateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Progress: " + i)
      }
    }
    return ResearchSubject.Progress(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      subjectState = subjectState,
      milestone = milestone,
      reason = reason,
      startDate = DateTime.of(FhirDateTime.fromString(startDate), _startDate),
      endDate = DateTime.of(FhirDateTime.fromString(endDate), _endDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ResearchSubject.Progress) {
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
    (value.subjectState)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    (value.milestone)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    (value.reason)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    ((value.startDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.startDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.startDateSer, it)
    }
    ((value.endDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.endDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.startDateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val startDateSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ResearchSubjectSerializer : KSerializer<ResearchSubject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchSubject") {
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
    b.element(
      "progress",
      listSerialDescriptor(lazyDescriptor { ResearchSubject.Progress.serializer().descriptor }),
      isOptional = true,
    )
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("study", Reference.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("assignedComparisonGroup", String.serializer().descriptor, isOptional = true)
    b.element("_assignedComparisonGroup", Element.serializer().descriptor, isOptional = true)
    b.element("actualComparisonGroup", String.serializer().descriptor, isOptional = true)
    b.element("_actualComparisonGroup", Element.serializer().descriptor, isOptional = true)
    b.element("consent", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ResearchSubject =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchSubject) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ResearchSubject")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ResearchSubject {
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
    var progress: List<ResearchSubject.Progress>? = null
    var period: Period? = null
    var study: Reference? = null
    var subject: Reference? = null
    var assignedComparisonGroup: String? = null
    var _assignedComparisonGroup: Element? = null
    var actualComparisonGroup: String? = null
    var _actualComparisonGroup: Element? = null
    var consent: List<Reference>? = null
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
        13 ->
          progress =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.progressSer, null)
        14 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        15 ->
          study = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studySer, null)
        16 ->
          subject = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.studySer, null)
        17 -> assignedComparisonGroup = decoder.decodeStringElement(descriptor, i)
        18 ->
          _assignedComparisonGroup =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> actualComparisonGroup = decoder.decodeStringElement(descriptor, i)
        20 ->
          _actualComparisonGroup =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          consent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.consentSer, null)
        else -> throw SerializationException("Unexpected index decoding ResearchSubject: " + i)
      }
    }
    return ResearchSubject(
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
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on ResearchSubject"),
      progress = progress ?: listOf(),
      period = period,
      study =
        study
          ?: throw SerializationException("Missing required property 'study' on ResearchSubject"),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on ResearchSubject"),
      assignedComparisonGroup = Id.of(assignedComparisonGroup, _assignedComparisonGroup),
      actualComparisonGroup = Id.of(actualComparisonGroup, _actualComparisonGroup),
      consent = consent ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchSubject,
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
    ((value.status.value?.code))?.let {
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
    if (value.progress.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.progressSer,
        value.progress,
      )
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.periodSer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.studySer,
      value.study,
    )
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      Hoisted.studySer,
      value.subject,
    )
    ((value.assignedComparisonGroup?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.assignedComparisonGroup?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.actualComparisonGroup?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.actualComparisonGroup?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.consent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.consentSer,
        value.consent,
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

    public val progressSerInner: KSerializer<ResearchSubject.Progress> =
      ResearchSubject.Progress.serializer()

    public val progressSer: KSerializer<List<ResearchSubject.Progress>> =
      ListSerializer(Hoisted.progressSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val studySer: KSerializer<Reference> = Reference.serializer()

    public val consentSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.studySer)
  }
}

internal object ResearchSubjectPolymorphicSerializer : KSerializer<ResearchSubject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchSubject") {
      ResearchSubjectSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchSubject) {
    encoder.encodeStructure(descriptor) {
      ResearchSubjectSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ResearchSubject =
    decoder.decodeStructure(descriptor) {
      ResearchSubjectSerializer.deserializeInternal(this, descriptor, 0)
    }
}
