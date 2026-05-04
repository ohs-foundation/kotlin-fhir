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

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.AllergyIntolerance
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object AllergyIntoleranceParticipantSerializer :
  KSerializer<AllergyIntolerance.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AllergyIntolerance.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return AllergyIntolerance.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AllergyIntolerance.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object AllergyIntoleranceReactionSerializer : KSerializer<AllergyIntolerance.Reaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reaction") {
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
      element("substance", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "manifestation",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("onset", KotlinString.serializer().descriptor, isOptional = true)
      element("_onset", Element.serializer().descriptor, isOptional = true)
      element("severity", KotlinString.serializer().descriptor, isOptional = true)
      element("_severity", Element.serializer().descriptor, isOptional = true)
      element("exposureRoute", CodeableConcept.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Reaction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Reaction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AllergyIntolerance.Reaction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var substance: CodeableConcept? = null
    var manifestation: List<CodeableReference>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var onset: KotlinString? = null
    var _onset: Element? = null
    var severity: KotlinString? = null
    var _severity: Element? = null
    var exposureRoute: CodeableConcept? = null
    var note: List<Annotation>? = null
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
          substance =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.substanceSer, null)
        4 ->
          manifestation =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.manifestationSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 -> onset = decoder.decodeStringElement(__desc, 7)
        8 ->
          _onset =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        9 -> severity = decoder.decodeStringElement(__desc, 9)
        10 ->
          _severity =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.descriptionSer, null)
        11 ->
          exposureRoute =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.substanceSer, null)
        12 -> note = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reaction: " + __i)
      }
    }
    return AllergyIntolerance.Reaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance,
      manifestation = manifestation ?: listOf(),
      description = R5String.of(description, _description),
      onset = DateTime.of(FhirDateTime.fromString(onset), _onset),
      severity =
        severity?.let {
          Enumeration.of(AllergyIntolerance.AllergyIntoleranceSeverity.fromCode(it), _severity)
        },
      exposureRoute = exposureRoute,
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AllergyIntolerance.Reaction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.substance)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.substanceSer, it)
    }
    if (value.manifestation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.manifestationSer, value.manifestation)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.onset?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.onset?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
    ((value.severity?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.severity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.descriptionSer, it)
    }
    (value.exposureRoute)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.substanceSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manifestationSerInner: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val manifestationSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.manifestationSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object AllergyIntoleranceSerializer : KSerializer<AllergyIntolerance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AllergyIntolerance") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("clinicalStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("verificationStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_category", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("criticality", KotlinString.serializer().descriptor, isOptional = true)
      element("_criticality", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("onsetDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_onsetDateTime", Element.serializer().descriptor, isOptional = true)
      element("onsetAge", Age.serializer().descriptor, isOptional = true)
      element("onsetPeriod", Period.serializer().descriptor, isOptional = true)
      element("onsetRange", Range.serializer().descriptor, isOptional = true)
      element("onsetString", KotlinString.serializer().descriptor, isOptional = true)
      element("_onsetString", Element.serializer().descriptor, isOptional = true)
      element("recordedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_recordedDate", Element.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(
          lazyDescriptor { AllergyIntolerance.Participant.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("lastOccurrence", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastOccurrence", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "reaction",
        listSerialDescriptor(
          lazyDescriptor { AllergyIntolerance.Reaction.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AllergyIntolerance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): AllergyIntolerance {
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
    var identifier: List<Identifier>? = null
    var clinicalStatus: CodeableConcept? = null
    var verificationStatus: CodeableConcept? = null
    var type: CodeableConcept? = null
    var category: List<KotlinString?>? = null
    var _category: List<Element?>? = null
    var criticality: KotlinString? = null
    var _criticality: Element? = null
    var code: CodeableConcept? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var onsetDateTime: KotlinString? = null
    var _onsetDateTime: Element? = null
    var onsetAge: Age? = null
    var onsetPeriod: Period? = null
    var onsetRange: Range? = null
    var onsetString: KotlinString? = null
    var _onsetString: Element? = null
    var recordedDate: KotlinString? = null
    var _recordedDate: Element? = null
    var participant: List<AllergyIntolerance.Participant>? = null
    var lastOccurrence: KotlinString? = null
    var _lastOccurrence: Element? = null
    var note: List<Annotation>? = null
    var reaction: List<AllergyIntolerance.Reaction>? = null
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
        12 ->
          clinicalStatus =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.clinicalStatusSer, null)
        13 ->
          verificationStatus =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.clinicalStatusSer, null)
        14 ->
          type =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.clinicalStatusSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 ->
          _category =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.categorySer2, null)
        17 -> criticality = decoder.decodeStringElement(__desc, 17)
        18 ->
          _criticality =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          code =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.clinicalStatusSer, null)
        20 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.patientSer, null)
        21 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.patientSer, null)
        22 -> onsetDateTime = decoder.decodeStringElement(__desc, 22)
        23 ->
          _onsetDateTime =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          onsetAge =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.onsetAgeSer, null)
        25 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.onsetPeriodSer, null)
        26 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.onsetRangeSer, null)
        27 -> onsetString = decoder.decodeStringElement(__desc, 27)
        28 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> recordedDate = decoder.decodeStringElement(__desc, 29)
        30 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.participantSer, null)
        32 -> lastOccurrence = decoder.decodeStringElement(__desc, 32)
        33 ->
          _lastOccurrence =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> note = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.noteSer, null)
        35 ->
          reaction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.reactionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AllergyIntolerance: " + __i)
      }
    }
    return AllergyIntolerance(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      clinicalStatus = clinicalStatus,
      verificationStatus = verificationStatus,
      type = type,
      category =
        (kotlin.collections.List(maxOf(category?.size ?: 0, _category?.size ?: 0)) { __i ->
          Enumeration.of(
            AllergyIntolerance.AllergyIntoleranceCategory.fromCode(category?.getOrNull(__i)!!),
            _category?.getOrNull(__i),
          )
        }),
      criticality =
        criticality?.let {
          Enumeration.of(
            AllergyIntolerance.AllergyIntoleranceCriticality.fromCode(it),
            _criticality,
          )
        },
      code = code,
      patient = patient!!,
      encounter = encounter,
      onset =
        AllergyIntolerance.Onset.from(
          DateTime.of(FhirDateTime.fromString(onsetDateTime), _onsetDateTime),
          onsetAge,
          onsetPeriod,
          onsetRange,
          R5String.of(onsetString, _onsetString),
        ),
      recordedDate = DateTime.of(FhirDateTime.fromString(recordedDate), _recordedDate),
      participant = participant ?: listOf(),
      lastOccurrence = DateTime.of(FhirDateTime.fromString(lastOccurrence), _lastOccurrence),
      note = note ?: listOf(),
      reaction = reaction ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AllergyIntolerance) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "AllergyIntolerance")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.clinicalStatus)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.clinicalStatusSer, it)
    }
    (value.verificationStatus)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.clinicalStatusSer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.clinicalStatusSer, it)
    }
    (value.category.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, it)
    }
    (value.category.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.categorySer2, it)
    }
    ((value.criticality?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.criticality?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.clinicalStatusSer, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.patientSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 21, Hoisted.patientSer, it) }
    when (val __d = value.onset) {
      null -> {}
      is AllergyIntolerance.Onset.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
        }
      }
      is AllergyIntolerance.Onset.Age -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.onsetAgeSer, __d.value)
      }
      is AllergyIntolerance.Onset.Period -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.onsetPeriodSer, __d.value)
      }
      is AllergyIntolerance.Onset.Range -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.onsetRangeSer, __d.value)
      }
      is AllergyIntolerance.Onset.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.recordedDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.participantSer, value.participant)
    ((value.lastOccurrence?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.lastOccurrence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.noteSer, value.note)
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.reactionSer, value.reaction)
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

    public val clinicalStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val categorySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.categorySerInner).nullable)

    public val categorySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val onsetAgeSer: KSerializer<Age> = Age.serializer()

    public val onsetPeriodSer: KSerializer<Period> = Period.serializer()

    public val onsetRangeSer: KSerializer<Range> = Range.serializer()

    public val participantSerInner: KSerializer<AllergyIntolerance.Participant> =
      AllergyIntolerance.Participant.serializer()

    public val participantSer: KSerializer<List<AllergyIntolerance.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val reactionSerInner: KSerializer<AllergyIntolerance.Reaction> =
      AllergyIntolerance.Reaction.serializer()

    public val reactionSer: KSerializer<List<AllergyIntolerance.Reaction>> =
      ListSerializer(Hoisted.reactionSerInner)
  }
}
