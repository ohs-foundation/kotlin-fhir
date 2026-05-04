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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.ResearchElementDefinition
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
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

internal object ResearchElementDefinitionCharacteristicSerializer :
  KSerializer<ResearchElementDefinition.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element(
        "definitionCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element("definitionExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "definitionDataRequirement",
        DataRequirement.serializer().descriptor,
        isOptional = true,
      )
      element(
        "usageContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("exclude", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exclude", Element.serializer().descriptor, isOptional = true)
      element("unitOfMeasure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("studyEffectiveDescription", KotlinString.serializer().descriptor, isOptional = true)
      element("_studyEffectiveDescription", Element.serializer().descriptor, isOptional = true)
      element("studyEffectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_studyEffectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("studyEffectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("studyEffectiveDuration", Duration.serializer().descriptor, isOptional = true)
      element("studyEffectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element("studyEffectiveTimeFromStart", Duration.serializer().descriptor, isOptional = true)
      element("studyEffectiveGroupMeasure", KotlinString.serializer().descriptor, isOptional = true)
      element("_studyEffectiveGroupMeasure", Element.serializer().descriptor, isOptional = true)
      element(
        "participantEffectiveDescription",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element(
        "_participantEffectiveDescription",
        Element.serializer().descriptor,
        isOptional = true,
      )
      element(
        "participantEffectiveDateTime",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element("_participantEffectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("participantEffectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("participantEffectiveDuration", Duration.serializer().descriptor, isOptional = true)
      element("participantEffectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element(
        "participantEffectiveTimeFromStart",
        Duration.serializer().descriptor,
        isOptional = true,
      )
      element(
        "participantEffectiveGroupMeasure",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element(
        "_participantEffectiveGroupMeasure",
        Element.serializer().descriptor,
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ResearchElementDefinition.Characteristic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var definitionCodeableConcept: CodeableConcept? = null
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionExpression: Expression? = null
    var definitionDataRequirement: DataRequirement? = null
    var usageContext: List<UsageContext>? = null
    var exclude: KotlinBoolean? = null
    var _exclude: Element? = null
    var unitOfMeasure: CodeableConcept? = null
    var studyEffectiveDescription: KotlinString? = null
    var _studyEffectiveDescription: Element? = null
    var studyEffectiveDateTime: KotlinString? = null
    var _studyEffectiveDateTime: Element? = null
    var studyEffectivePeriod: Period? = null
    var studyEffectiveDuration: Duration? = null
    var studyEffectiveTiming: Timing? = null
    var studyEffectiveTimeFromStart: Duration? = null
    var studyEffectiveGroupMeasure: KotlinString? = null
    var _studyEffectiveGroupMeasure: Element? = null
    var participantEffectiveDescription: KotlinString? = null
    var _participantEffectiveDescription: Element? = null
    var participantEffectiveDateTime: KotlinString? = null
    var _participantEffectiveDateTime: Element? = null
    var participantEffectivePeriod: Period? = null
    var participantEffectiveDuration: Duration? = null
    var participantEffectiveTiming: Timing? = null
    var participantEffectiveTimeFromStart: Duration? = null
    var participantEffectiveGroupMeasure: KotlinString? = null
    var _participantEffectiveGroupMeasure: Element? = null
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
          definitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        4 -> definitionCanonical = decoder.decodeStringElement(__desc, 4)
        5 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.definitionCanonicalSer,
              null,
            )
        6 ->
          definitionExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.definitionExpressionSer,
              null,
            )
        7 ->
          definitionDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.definitionDataRequirementSer,
              null,
            )
        8 ->
          usageContext =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.usageContextSer, null)
        9 -> exclude = decoder.decodeBooleanElement(__desc, 9)
        10 ->
          _exclude =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.definitionCanonicalSer,
              null,
            )
        11 ->
          unitOfMeasure =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        12 -> studyEffectiveDescription = decoder.decodeStringElement(__desc, 12)
        13 ->
          _studyEffectiveDescription =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.definitionCanonicalSer,
              null,
            )
        14 -> studyEffectiveDateTime = decoder.decodeStringElement(__desc, 14)
        15 ->
          _studyEffectiveDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.definitionCanonicalSer,
              null,
            )
        16 ->
          studyEffectivePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.studyEffectivePeriodSer,
              null,
            )
        17 ->
          studyEffectiveDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        18 ->
          studyEffectiveTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.studyEffectiveTimingSer,
              null,
            )
        19 ->
          studyEffectiveTimeFromStart =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        20 -> studyEffectiveGroupMeasure = decoder.decodeStringElement(__desc, 20)
        21 ->
          _studyEffectiveGroupMeasure =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.definitionCanonicalSer,
              null,
            )
        22 -> participantEffectiveDescription = decoder.decodeStringElement(__desc, 22)
        23 ->
          _participantEffectiveDescription =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.definitionCanonicalSer,
              null,
            )
        24 -> participantEffectiveDateTime = decoder.decodeStringElement(__desc, 24)
        25 ->
          _participantEffectiveDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.definitionCanonicalSer,
              null,
            )
        26 ->
          participantEffectivePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.studyEffectivePeriodSer,
              null,
            )
        27 ->
          participantEffectiveDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        28 ->
          participantEffectiveTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              28,
              Hoisted.studyEffectiveTimingSer,
              null,
            )
        29 ->
          participantEffectiveTimeFromStart =
            decoder.decodeNullableSerializableElement(
              __desc,
              29,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        30 -> participantEffectiveGroupMeasure = decoder.decodeStringElement(__desc, 30)
        31 ->
          _participantEffectiveGroupMeasure =
            decoder.decodeNullableSerializableElement(
              __desc,
              31,
              Hoisted.definitionCanonicalSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
      }
    }
    return ResearchElementDefinition.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      definition =
        ResearchElementDefinition.Characteristic.Definition.from(
          definitionCodeableConcept,
          Canonical.of(definitionCanonical, _definitionCanonical),
          definitionExpression,
          definitionDataRequirement,
        )!!,
      usageContext = usageContext ?: listOf(),
      exclude = R4Boolean.of(exclude, _exclude),
      unitOfMeasure = unitOfMeasure,
      studyEffectiveDescription =
        R4String.of(studyEffectiveDescription, _studyEffectiveDescription),
      studyEffective =
        ResearchElementDefinition.Characteristic.StudyEffective.from(
          DateTime.of(FhirDateTime.fromString(studyEffectiveDateTime), _studyEffectiveDateTime),
          studyEffectivePeriod,
          studyEffectiveDuration,
          studyEffectiveTiming,
        ),
      studyEffectiveTimeFromStart = studyEffectiveTimeFromStart,
      studyEffectiveGroupMeasure =
        studyEffectiveGroupMeasure?.let {
          Enumeration.of(
            ResearchElementDefinition.GroupMeasure.fromCode(it),
            _studyEffectiveGroupMeasure,
          )
        },
      participantEffectiveDescription =
        R4String.of(participantEffectiveDescription, _participantEffectiveDescription),
      participantEffective =
        ResearchElementDefinition.Characteristic.ParticipantEffective.from(
          DateTime.of(
            FhirDateTime.fromString(participantEffectiveDateTime),
            _participantEffectiveDateTime,
          ),
          participantEffectivePeriod,
          participantEffectiveDuration,
          participantEffectiveTiming,
        ),
      participantEffectiveTimeFromStart = participantEffectiveTimeFromStart,
      participantEffectiveGroupMeasure =
        participantEffectiveGroupMeasure?.let {
          Enumeration.of(
            ResearchElementDefinition.GroupMeasure.fromCode(it),
            _participantEffectiveGroupMeasure,
          )
        },
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ResearchElementDefinition.Characteristic,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.definition) {
      null -> {}
      is ResearchElementDefinition.Characteristic.Definition.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          3,
          Hoisted.definitionCodeableConceptSer,
          __d.value,
        )
      }
      is ResearchElementDefinition.Characteristic.Definition.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.definitionCanonicalSer, it)
        }
      }
      is ResearchElementDefinition.Characteristic.Definition.Expression -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.definitionExpressionSer, __d.value)
      }
      is ResearchElementDefinition.Characteristic.Definition.DataRequirement -> {
        encoder.encodeSerializableElement(
          __desc,
          7,
          Hoisted.definitionDataRequirementSer,
          __d.value,
        )
      }
    }
    if (value.usageContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.usageContextSer, value.usageContext)
    ((value.exclude?.value))?.let { encoder.encodeBooleanElement(__desc, 9, it) }
    (value.exclude?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.definitionCanonicalSer, it)
    }
    (value.unitOfMeasure)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.definitionCodeableConceptSer, it)
    }
    ((value.studyEffectiveDescription?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.studyEffectiveDescription?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.definitionCanonicalSer, it)
    }
    when (val __d = value.studyEffective) {
      null -> {}
      is ResearchElementDefinition.Characteristic.StudyEffective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.definitionCanonicalSer, it)
        }
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Period -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.studyEffectivePeriodSer, __d.value)
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Duration -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.studyEffectiveDurationSer, __d.value)
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Timing -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.studyEffectiveTimingSer, __d.value)
      }
    }
    (value.studyEffectiveTimeFromStart)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.studyEffectiveDurationSer, it)
    }
    ((value.studyEffectiveGroupMeasure?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 20, it)
    }
    (value.studyEffectiveGroupMeasure?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.definitionCanonicalSer, it)
    }
    ((value.participantEffectiveDescription?.value))?.let {
      encoder.encodeStringElement(__desc, 22, it)
    }
    (value.participantEffectiveDescription?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.definitionCanonicalSer, it)
    }
    when (val __d = value.participantEffective) {
      null -> {}
      is ResearchElementDefinition.Characteristic.ParticipantEffective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25, Hoisted.definitionCanonicalSer, it)
        }
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Period -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.studyEffectivePeriodSer, __d.value)
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Duration -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.studyEffectiveDurationSer, __d.value)
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Timing -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.studyEffectiveTimingSer, __d.value)
      }
    }
    (value.participantEffectiveTimeFromStart)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.studyEffectiveDurationSer, it)
    }
    ((value.participantEffectiveGroupMeasure?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 30, it)
    }
    (value.participantEffectiveGroupMeasure?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.definitionCanonicalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val definitionCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val definitionCanonicalSer: KSerializer<Element> = Element.serializer()

    public val definitionExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val definitionDataRequirementSer: KSerializer<DataRequirement> =
      DataRequirement.serializer()

    public val usageContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val usageContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.usageContextSerInner)

    public val studyEffectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val studyEffectiveDurationSer: KSerializer<Duration> = Duration.serializer()

    public val studyEffectiveTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object ResearchElementDefinitionSerializer : KSerializer<ResearchElementDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchElementDefinition") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("shortTitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_shortTitle", Element.serializer().descriptor, isOptional = true)
      element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_subtitle", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "comment",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_comment", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("usage", KotlinString.serializer().descriptor, isOptional = true)
      element("_usage", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "topic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "author",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "editor",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewer",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endorser",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "library",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("variableType", KotlinString.serializer().descriptor, isOptional = true)
      element("_variableType", Element.serializer().descriptor, isOptional = true)
      element(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { ResearchElementDefinition.Characteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ResearchElementDefinition {
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
    var shortTitle: KotlinString? = null
    var _shortTitle: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var comment: List<KotlinString?>? = null
    var _comment: List<Element?>? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var variableType: KotlinString? = null
    var _variableType: Element? = null
    var characteristic: List<ResearchElementDefinition.Characteristic>? = null
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
        20 -> shortTitle = decoder.decodeStringElement(__desc, 20)
        21 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> subtitle = decoder.decodeStringElement(__desc, 22)
        23 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> status = decoder.decodeStringElement(__desc, 24)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> experimental = decoder.decodeBooleanElement(__desc, 26)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              28,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        29 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.subjectReferenceSer, null)
        30 -> date = decoder.decodeStringElement(__desc, 30)
        31 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 -> publisher = decoder.decodeStringElement(__desc, 32)
        33 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.contactSer, null)
        35 -> description = decoder.decodeStringElement(__desc, 35)
        36 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          comment = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.commentSer, null)
        38 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.commentSer2, null)
        39 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.useContextSer, null)
        40 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.jurisdictionSer, null)
        41 -> purpose = decoder.decodeStringElement(__desc, 41)
        42 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.implicitRulesSer, null)
        43 -> usage = decoder.decodeStringElement(__desc, 43)
        44 ->
          _usage =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.implicitRulesSer, null)
        45 -> copyright = decoder.decodeStringElement(__desc, 45)
        46 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.implicitRulesSer, null)
        47 -> approvalDate = decoder.decodeStringElement(__desc, 47)
        48 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.implicitRulesSer, null)
        49 -> lastReviewDate = decoder.decodeStringElement(__desc, 49)
        50 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.implicitRulesSer, null)
        51 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.effectivePeriodSer, null)
        52 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.jurisdictionSer, null)
        53 ->
          author = decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.contactSer, null)
        54 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.contactSer, null)
        55 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.contactSer, null)
        56 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.contactSer, null)
        57 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.relatedArtifactSer, null)
        58 ->
          library = decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.commentSer, null)
        59 ->
          _library =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.commentSer2, null)
        60 -> type = decoder.decodeStringElement(__desc, 60)
        61 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 61, Hoisted.implicitRulesSer, null)
        62 -> variableType = decoder.decodeStringElement(__desc, 62)
        63 ->
          _variableType =
            decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.implicitRulesSer, null)
        64 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.characteristicSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ResearchElementDefinition: " + __i
          )
      }
    }
    return ResearchElementDefinition(
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      shortTitle = R4String.of(shortTitle, _shortTitle),
      subtitle = R4String.of(subtitle, _subtitle),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = ResearchElementDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      comment =
        (kotlin.collections.List(maxOf(comment?.size ?: 0, _comment?.size ?: 0)) { __i ->
          R4String.of(comment?.getOrNull(__i)?.let { it }, _comment?.getOrNull(__i))!!
        }),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { __i ->
          Canonical.of(library?.getOrNull(__i)?.let { it }, _library?.getOrNull(__i))!!
        }),
      type = Enumeration.of(ResearchElementDefinition.ResearchElementType.fromCode(type!!), _type),
      variableType =
        variableType?.let {
          Enumeration.of(ResearchElementDefinition.EvidenceVariableType.fromCode(it), _variableType)
        },
      characteristic = characteristic ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ResearchElementDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ResearchElementDefinition")
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
    ((value.shortTitle?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.shortTitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 26, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is ResearchElementDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 28, Hoisted.subjectCodeableConceptSer, __d.value)
      }
      is ResearchElementDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(__desc, 29, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    (value.comment.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.commentSer, it)
    }
    (value.comment.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.commentSer2, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 41, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.implicitRulesSer, it)
    }
    ((value.usage?.value))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 45, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 47, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 49, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 51, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 55, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 56, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        57,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.commentSer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.commentSer2, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 60, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 61, Hoisted.implicitRulesSer, it)
    }
    ((value.variableType?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 62, it) }
    (value.variableType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 63, Hoisted.implicitRulesSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 64, Hoisted.characteristicSer, value.characteristic)
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

    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val commentSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val commentSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.commentSerInner).nullable)

    public val commentSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subjectCodeableConceptSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val characteristicSerInner: KSerializer<ResearchElementDefinition.Characteristic> =
      ResearchElementDefinition.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<ResearchElementDefinition.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)
  }
}
