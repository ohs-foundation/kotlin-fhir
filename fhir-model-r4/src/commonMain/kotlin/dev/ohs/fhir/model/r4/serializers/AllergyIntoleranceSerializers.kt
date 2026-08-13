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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.AllergyIntolerance
import dev.ohs.fhir.model.r4.Annotation
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
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Reaction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): AllergyIntolerance.Reaction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var substance: CodeableConcept? = null
    var manifestation: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var onset: KotlinString? = null
    var _onset: Element? = null
    var severity: KotlinString? = null
    var _severity: Element? = null
    var exposureRoute: CodeableConcept? = null
    var note: List<Annotation>? = null
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
          substance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substanceSer, null)
        4 ->
          manifestation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manifestationSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        7 -> onset = decoder.decodeStringElement(descriptor, i)
        8 ->
          _onset =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        9 -> severity = decoder.decodeStringElement(descriptor, i)
        10 ->
          _severity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        11 ->
          exposureRoute =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substanceSer, null)
        12 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reaction: " + i)
      }
    }
    return AllergyIntolerance.Reaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance,
      manifestation = manifestation ?: listOf(),
      description = R4String.of(description, _description),
      onset = DateTime.of(onset?.let { FhirDateTime.fromString(it) }, _onset),
      severity =
        severity?.let {
          Enumeration.of(AllergyIntolerance.AllergyIntoleranceSeverity.fromCode(it), _severity)
        },
      exposureRoute = exposureRoute,
      note = note ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: AllergyIntolerance.Reaction) {
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
    (value.substance)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.substanceSer, it)
    }
    if (value.manifestation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        Hoisted.manifestationSer,
        value.manifestation,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.descriptionSer, it)
    }
    ((value.onset?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.onset?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.descriptionSer, it)
    }
    ((value.severity?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.severity?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.descriptionSer, it)
    }
    (value.exposureRoute)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.substanceSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manifestationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.substanceSer)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object AllergyIntoleranceSerializer : KSerializer<AllergyIntolerance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AllergyIntolerance") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("clinicalStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("verificationStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_category", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("criticality", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_criticality", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("onsetDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_onsetDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("onsetAge", Age.serializer().descriptor, isOptional = true)
    b.element("onsetPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("onsetRange", Range.serializer().descriptor, isOptional = true)
    b.element("onsetString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_onsetString", Element.serializer().descriptor, isOptional = true)
    b.element("recordedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recordedDate", Element.serializer().descriptor, isOptional = true)
    b.element("recorder", Reference.serializer().descriptor, isOptional = true)
    b.element("asserter", Reference.serializer().descriptor, isOptional = true)
    b.element("lastOccurrence", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastOccurrence", Element.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "reaction",
      listSerialDescriptor(lazyDescriptor { AllergyIntolerance.Reaction.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): AllergyIntolerance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AllergyIntolerance")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AllergyIntolerance {
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
    var type: KotlinString? = null
    var _type: Element? = null
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
    var recorder: Reference? = null
    var asserter: Reference? = null
    var lastOccurrence: KotlinString? = null
    var _lastOccurrence: Element? = null
    var note: List<Annotation>? = null
    var reaction: List<AllergyIntolerance.Reaction>? = null
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
        11 ->
          clinicalStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.clinicalStatusSer,
              null,
            )
        12 ->
          verificationStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.clinicalStatusSer,
              null,
            )
        13 -> type = decoder.decodeStringElement(descriptor, i)
        14 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        16 ->
          _category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer2, null)
        17 -> criticality = decoder.decodeStringElement(descriptor, i)
        18 ->
          _criticality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.clinicalStatusSer,
              null,
            )
        20 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        21 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        22 -> onsetDateTime = decoder.decodeStringElement(descriptor, i)
        23 ->
          _onsetDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          onsetAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onsetAgeSer, null)
        25 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onsetPeriodSer, null)
        26 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.onsetRangeSer, null)
        27 -> onsetString = decoder.decodeStringElement(descriptor, i)
        28 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        30 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        32 ->
          asserter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        33 -> lastOccurrence = decoder.decodeStringElement(descriptor, i)
        34 ->
          _lastOccurrence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        36 ->
          reaction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reactionSer, null)
        else -> throw SerializationException("Unexpected index decoding AllergyIntolerance: " + i)
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
      type =
        type?.let { Enumeration.of(AllergyIntolerance.AllergyIntoleranceType.fromCode(it), _type) },
      category =
        (kotlin.collections.List(maxOf(category?.size ?: 0, _category?.size ?: 0)) { index ->
          Enumeration.of(
            AllergyIntolerance.AllergyIntoleranceCategory.fromCode(category?.getOrNull(index)!!),
            _category?.getOrNull(index),
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
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on AllergyIntolerance"
          ),
      encounter = encounter,
      onset =
        AllergyIntolerance.Onset.from(
          DateTime.of(onsetDateTime?.let { FhirDateTime.fromString(it) }, _onsetDateTime),
          onsetAge,
          onsetPeriod,
          onsetRange,
          R4String.of(onsetString, _onsetString),
        ),
      recordedDate = DateTime.of(recordedDate?.let { FhirDateTime.fromString(it) }, _recordedDate),
      recorder = recorder,
      asserter = asserter,
      lastOccurrence =
        DateTime.of(lastOccurrence?.let { FhirDateTime.fromString(it) }, _lastOccurrence),
      note = note ?: listOf(),
      reaction = reaction ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AllergyIntolerance,
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
    (value.clinicalStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.clinicalStatusSer,
        it,
      )
    }
    (value.verificationStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.clinicalStatusSer,
        it,
      )
    }
    ((value.type?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.category.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.categorySer, it)
    }
    (value.category.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.categorySer2, it)
    }
    ((value.criticality?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.criticality?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.clinicalStatusSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.patientSer, it)
    }
    when (val choice = value.onset) {
      null -> {}
      is AllergyIntolerance.Onset.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            23 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is AllergyIntolerance.Onset.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          Hoisted.onsetAgeSer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          Hoisted.onsetPeriodSer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          Hoisted.onsetRangeSer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            28 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.recordedDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.recorder)?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.asserter)?.let {
      encoder.encodeSerializableElement(descriptor, 32 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.lastOccurrence?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.lastOccurrence?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.reactionSer,
        value.reaction,
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

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val reactionSerInner: KSerializer<AllergyIntolerance.Reaction> =
      AllergyIntolerance.Reaction.serializer()

    public val reactionSer: KSerializer<List<AllergyIntolerance.Reaction>> =
      ListSerializer(Hoisted.reactionSerInner)
  }
}

internal object AllergyIntolerancePolymorphicSerializer : KSerializer<AllergyIntolerance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AllergyIntolerance") {
      AllergyIntoleranceSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance) {
    encoder.encodeStructure(descriptor) {
      AllergyIntoleranceSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): AllergyIntolerance =
    decoder.decodeStructure(descriptor) {
      AllergyIntoleranceSerializer.deserializeInternal(this, descriptor, 0)
    }
}
