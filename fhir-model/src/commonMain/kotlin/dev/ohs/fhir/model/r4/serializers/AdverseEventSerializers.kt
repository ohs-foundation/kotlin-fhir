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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.AdverseEvent
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          instance = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.instanceSer, null)
        4 ->
          causality =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.causalitySer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          assessment =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.assessmentSer, null)
        4 -> productRelatedness = decoder.decodeStringElement(__desc, 4)
        5 ->
          _productRelatedness =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.productRelatednessSer,
              null,
            )
        6 -> author = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.authorSer, null)
        7 ->
          method = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.assessmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Causality: " + __i)
      }
    }
    return AdverseEvent.SuspectEntity.Causality(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      assessment = assessment,
      productRelatedness = R4String.of(productRelatedness, _productRelatedness),
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("actuality", KotlinString.serializer().descriptor, isOptional = true)
      element("_actuality", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("event", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("detected", KotlinString.serializer().descriptor, isOptional = true)
      element("_detected", Element.serializer().descriptor, isOptional = true)
      element("recordedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_recordedDate", Element.serializer().descriptor, isOptional = true)
      element(
        "resultingCondition",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("seriousness", CodeableConcept.serializer().descriptor, isOptional = true)
      element("severity", CodeableConcept.serializer().descriptor, isOptional = true)
      element("outcome", CodeableConcept.serializer().descriptor, isOptional = true)
      element("recorder", Reference.serializer().descriptor, isOptional = true)
      element(
        "contributor",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "suspectEntity",
        listSerialDescriptor(lazyDescriptor { AdverseEvent.SuspectEntity.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "subjectMedicalHistory",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "referenceDocument",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("study", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): AdverseEvent {
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
        12 -> actuality = decoder.decodeStringElement(__desc, 12)
        13 ->
          _actuality =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.categorySer, null)
        15 ->
          event =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySerInner, null)
        16 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subjectSer, null)
        17 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subjectSer, null)
        18 -> date = decoder.decodeStringElement(__desc, 18)
        19 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> detected = decoder.decodeStringElement(__desc, 20)
        21 ->
          _detected =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> recordedDate = decoder.decodeStringElement(__desc, 22)
        23 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          resultingCondition =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.resultingConditionSer,
              null,
            )
        25 ->
          location = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.subjectSer, null)
        26 ->
          seriousness =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.categorySerInner, null)
        27 ->
          severity =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.categorySerInner, null)
        28 ->
          outcome =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.categorySerInner, null)
        29 ->
          recorder = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.subjectSer, null)
        30 ->
          contributor =
            decoder.decodeNullableSerializableElement(
              __desc,
              30,
              Hoisted.resultingConditionSer,
              null,
            )
        31 ->
          suspectEntity =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.suspectEntitySer, null)
        32 ->
          subjectMedicalHistory =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.resultingConditionSer,
              null,
            )
        33 ->
          referenceDocument =
            decoder.decodeNullableSerializableElement(
              __desc,
              33,
              Hoisted.resultingConditionSer,
              null,
            )
        34 ->
          study =
            decoder.decodeNullableSerializableElement(
              __desc,
              34,
              Hoisted.resultingConditionSer,
              null,
            )
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: AdverseEvent) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "AdverseEvent")
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, it)
    }
    ((value.actuality.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.actuality.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.categorySer, value.category)
    (value.event)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySerInner, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.subjectSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.detected?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.detected?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.recordedDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    if (value.resultingCondition.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24,
        Hoisted.resultingConditionSer,
        value.resultingCondition,
      )
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.subjectSer, it) }
    (value.seriousness)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.categorySerInner, it)
    }
    (value.severity)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.categorySerInner, it)
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.categorySerInner, it)
    }
    (value.recorder)?.let { encoder.encodeSerializableElement(__desc, 29, Hoisted.subjectSer, it) }
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30,
        Hoisted.resultingConditionSer,
        value.contributor,
      )
    if (value.suspectEntity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.suspectEntitySer, value.suspectEntity)
    if (value.subjectMedicalHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32,
        Hoisted.resultingConditionSer,
        value.subjectMedicalHistory,
      )
    if (value.referenceDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33,
        Hoisted.resultingConditionSer,
        value.referenceDocument,
      )
    if (value.study.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.resultingConditionSer, value.study)
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
