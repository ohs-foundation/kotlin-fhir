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

import dev.ohs.fhir.model.r4b.AdverseEvent
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object AdverseEventSuspectEntitySerializer : KSerializer<AdverseEvent.SuspectEntity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SuspectEntity") {
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
      element("instance", Reference.serializer().descriptor, isOptional = true)
      element(
        "causality",
        listSerialDescriptor(
          lazyDescriptor { AdverseEvent.SuspectEntity.Causality.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.SuspectEntity {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instance: Reference? = null
    var causality: List<AdverseEvent.SuspectEntity.Causality>? = null
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
          instance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instanceSer, null)
        4 ->
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
        instance
          ?: throw SerializationException(
            "Missing required property 'instance' on AdverseEvent.SuspectEntity"
          ),
      causality = causality ?: listOf(),
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.instanceSer, value.instance)
    if (value.causality.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.causalitySer, value.causality)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val instanceSer: KSerializer<Reference> = Reference.serializer()

    public val causalitySerInner: KSerializer<AdverseEvent.SuspectEntity.Causality> =
      AdverseEvent.SuspectEntity.Causality.serializer()

    public val causalitySer: KSerializer<List<AdverseEvent.SuspectEntity.Causality>> =
      ListSerializer(Hoisted.causalitySerInner)
  }
}

internal object AdverseEventSuspectEntityCausalitySerializer :
  KSerializer<AdverseEvent.SuspectEntity.Causality> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Causality") {
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
      element("assessment", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productRelatedness", KotlinString.serializer().descriptor, isOptional = true)
      element("_productRelatedness", Element.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AdverseEvent.SuspectEntity.Causality {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var assessment: CodeableConcept? = null
    var productRelatedness: KotlinString? = null
    var _productRelatedness: Element? = null
    var author: Reference? = null
    var method: CodeableConcept? = null
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
          assessment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assessmentSer, null)
        4 -> productRelatedness = decoder.decodeStringElement(descriptor, i)
        5 ->
          _productRelatedness =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.productRelatednessSer,
              null,
            )
        6 ->
          author = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorSer, null)
        7 ->
          method =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assessmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Causality: " + i)
      }
    }
    return AdverseEvent.SuspectEntity.Causality(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      assessment = assessment,
      productRelatedness = R4bString.of(productRelatedness, _productRelatedness),
      author = author,
      method = method,
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
    (value.assessment)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.assessmentSer, it)
    }
    ((value.productRelatedness?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.productRelatedness?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.productRelatednessSer, it)
    }
    (value.author)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.authorSer, it) }
    (value.method)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.assessmentSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val assessmentSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val productRelatednessSer: KSerializer<Element> = Element.serializer()

    public val authorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object AdverseEventSerializer : KSerializer<AdverseEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdverseEvent") {
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
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("actuality", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_actuality", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("event", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("detected", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_detected", Element.serializer().descriptor, isOptional = true)
    b.element("recordedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recordedDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "resultingCondition",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("seriousness", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("severity", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("outcome", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("recorder", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "contributor",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "suspectEntity",
      listSerialDescriptor(lazyDescriptor { AdverseEvent.SuspectEntity.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "subjectMedicalHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "referenceDocument",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("study", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

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
    var identifier: Identifier? = null
    var actuality: KotlinString? = null
    var _actuality: Element? = null
    var category: List<CodeableConcept>? = null
    var event: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var detected: KotlinString? = null
    var _detected: Element? = null
    var recordedDate: KotlinString? = null
    var _recordedDate: Element? = null
    var resultingCondition: List<Reference>? = null
    var location: Reference? = null
    var seriousness: CodeableConcept? = null
    var severity: CodeableConcept? = null
    var outcome: CodeableConcept? = null
    var recorder: Reference? = null
    var contributor: List<Reference>? = null
    var suspectEntity: List<AdverseEvent.SuspectEntity>? = null
    var subjectMedicalHistory: List<Reference>? = null
    var referenceDocument: List<Reference>? = null
    var study: List<Reference>? = null
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
        11 -> actuality = decoder.decodeStringElement(descriptor, i)
        12 ->
          _actuality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        14 ->
          event =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        17 -> date = decoder.decodeStringElement(descriptor, i)
        18 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> detected = decoder.decodeStringElement(descriptor, i)
        20 ->
          _detected =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        22 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          resultingCondition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingConditionSer,
              null,
            )
        24 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        25 ->
          seriousness =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        26 ->
          severity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        27 ->
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        28 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        29 ->
          contributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingConditionSer,
              null,
            )
        30 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.suspectEntitySer, null)
        31 ->
          subjectMedicalHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingConditionSer,
              null,
            )
        32 ->
          referenceDocument =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingConditionSer,
              null,
            )
        33 ->
          study =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resultingConditionSer,
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
      identifier = identifier,
      actuality =
        Enumeration.of(
          actuality?.let { AdverseEvent.AdverseEventActuality.fromCode(it) },
          _actuality,
        ) ?: throw SerializationException("Missing required property 'actuality' on AdverseEvent"),
      category = category ?: listOf(),
      event = event,
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on AdverseEvent"),
      encounter = encounter,
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      detected = DateTime.of(detected?.let { FhirDateTime.fromString(it) }, _detected),
      recordedDate = DateTime.of(recordedDate?.let { FhirDateTime.fromString(it) }, _recordedDate),
      resultingCondition = resultingCondition ?: listOf(),
      location = location,
      seriousness = seriousness,
      severity = severity,
      outcome = outcome,
      recorder = recorder,
      contributor = contributor ?: listOf(),
      suspectEntity = suspectEntity ?: listOf(),
      subjectMedicalHistory = subjectMedicalHistory ?: listOf(),
      referenceDocument = referenceDocument ?: listOf(),
      study = study ?: listOf(),
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        it,
      )
    }
    ((value.actuality.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.actuality.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    (value.event)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.subjectSer,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.detected?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.detected?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.recordedDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.resultingCondition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.resultingConditionSer,
        value.resultingCondition,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.seriousness)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    (value.severity)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.resultingConditionSer,
        value.contributor,
      )
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.suspectEntitySer,
        value.suspectEntity,
      )
    if (value.subjectMedicalHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.resultingConditionSer,
        value.subjectMedicalHistory,
      )
    if (value.referenceDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.resultingConditionSer,
        value.referenceDocument,
      )
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.resultingConditionSer,
        value.study,
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val resultingConditionSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.subjectSer)

    public val suspectEntitySerInner: KSerializer<AdverseEvent.SuspectEntity> =
      AdverseEvent.SuspectEntity.serializer()

    public val suspectEntitySer: KSerializer<List<AdverseEvent.SuspectEntity>> =
      ListSerializer(Hoisted.suspectEntitySerInner)
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
