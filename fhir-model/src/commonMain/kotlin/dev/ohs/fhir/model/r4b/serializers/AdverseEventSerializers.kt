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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.SuspectEntity {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var instance: Reference? = null
    var causality: List<AdverseEvent.SuspectEntity.Causality>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          instance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.instanceSer, null)
        4 ->
          causality =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.causalitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SuspectEntity: " + __i)
      }
    }
    return AdverseEvent.SuspectEntity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      instance = instance!!,
      causality = causality ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent.SuspectEntity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.instance)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.instanceSer, it) }
    if (value.causality.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.causalitySer, value.causality)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdverseEvent.SuspectEntity.Causality {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var assessment: CodeableConcept? = null
    var productRelatedness: KotlinString? = null
    var _productRelatedness: Element? = null
    var author: Reference? = null
    var method: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          assessment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.assessmentSer, null)
        4 -> productRelatedness = decoder.decodeStringElement(__desc, __i)
        5 ->
          _productRelatedness =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.productRelatednessSer,
              null,
            )
        6 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.authorSer, null)
        7 ->
          method =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.assessmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Causality: " + __i)
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
    (value.assessment)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.assessmentSer, it)
    }
    ((value.productRelatedness?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.productRelatedness?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.productRelatednessSer, it)
    }
    (value.author)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.authorSer, it) }
    (value.method)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.assessmentSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AdverseEvent")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): AdverseEvent {
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> actuality = decoder.decodeStringElement(__desc, __i)
        12 ->
          _actuality =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        14 ->
          event =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        15 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        17 -> date = decoder.decodeStringElement(__desc, __i)
        18 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> detected = decoder.decodeStringElement(__desc, __i)
        20 ->
          _detected =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> recordedDate = decoder.decodeStringElement(__desc, __i)
        22 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          resultingCondition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.resultingConditionSer,
              null,
            )
        24 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        25 ->
          seriousness =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        26 ->
          severity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        27 ->
          outcome =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySerInner, null)
        28 ->
          recorder =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        29 ->
          contributor =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.resultingConditionSer,
              null,
            )
        30 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.suspectEntitySer, null)
        31 ->
          subjectMedicalHistory =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.resultingConditionSer,
              null,
            )
        32 ->
          referenceDocument =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.resultingConditionSer,
              null,
            )
        33 ->
          study =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.resultingConditionSer,
              null,
            )
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
      identifier = identifier,
      actuality =
        Enumeration.of(AdverseEvent.AdverseEventActuality.fromCode(actuality!!), _actuality),
      category = category ?: listOf(),
      event = event,
      subject = subject!!,
      encounter = encounter,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      detected = DateTime.of(FhirDateTime.fromString(detected), _detected),
      recordedDate = DateTime.of(FhirDateTime.fromString(recordedDate), _recordedDate),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: AdverseEvent,
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, it)
    }
    ((value.actuality.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 11 + __off, it)
    }
    (value.actuality.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.categorySer, value.category)
    (value.event)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.subjectSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.subjectSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.detected?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 19 + __off, it)
    }
    (value.detected?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.recordedDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 21 + __off, it)
    }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.resultingCondition.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23 + __off,
        Hoisted.resultingConditionSer,
        value.resultingCondition,
      )
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.subjectSer, it)
    }
    (value.seriousness)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.categorySerInner, it)
    }
    (value.severity)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.categorySerInner, it)
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.categorySerInner, it)
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.subjectSer, it)
    }
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.resultingConditionSer,
        value.contributor,
      )
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30 + __off,
        Hoisted.suspectEntitySer,
        value.suspectEntity,
      )
    if (value.subjectMedicalHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31 + __off,
        Hoisted.resultingConditionSer,
        value.subjectMedicalHistory,
      )
    if (value.referenceDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32 + __off,
        Hoisted.resultingConditionSer,
        value.referenceDocument,
      )
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33 + __off,
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
      AdverseEventSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    decoder.decodeStructure(descriptor) {
      AdverseEventSerializer.deserializeJson(this, descriptor, 0)
    }
}
